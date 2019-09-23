import json
import pprint

from aea_schema import WEATHER_DATA_MODEL, TEMPERATURE_ATTR, AIR_PRESSURE_ATTR, HUMIDITY_ATTR
from oef.agents import OEFAgent

from typing import List
from oef.proxy import PROPOSE_TYPES
from oef.query import Eq, Constraint
from oef.query import Query, SearchResultItem


class WeatherClient(OEFAgent):
    """Class that implements the behavior of the weather client."""

    def on_search_result_wide(self, search_id: int, agents: List[SearchResultItem]):
        """For every agent returned in the service search, send a CFP to obtain resources from them."""
        if len(agents) == 0:
            print("[{}]: No agent found. Stopping...".format(self.public_key))
            self.stop()
            return

        print("[{0}]: Agent found: {1}".format(self.public_key, len(agents)))
        for agent in agents:
            print("[{0}]: Sending to agent {1}".format(self.public_key, agent.public_key))
            # we send a 'None' query, meaning "give me all the resources you can propose."
            query = None
            self.send_cfp(1, 0, agent.public_key, 0, query)

    def on_propose(self, msg_id: int, dialogue_id: int, origin: str, target: int, proposals: PROPOSE_TYPES):
        """When we receive a Propose message, answer with an Accept."""
        print("[{0}]: Received propose from agent {1}".format(self.public_key, origin))
        for i, p in enumerate(proposals):
            print("[{0}]: Proposal {1}: {2}".format(self.public_key, i, p.values))
        print("[{0}]: Accepting Propose.".format(self.public_key))
        self.send_accept(msg_id, dialogue_id, origin, msg_id + 1)

    def on_message(self, msg_id: int, dialogue_id: int, origin: str, content: bytes):
        """Extract and print data from incoming (simple) messages."""
        data = json.loads(content.decode("utf-8"))
        print("[{0}]: Received measurement from {1}: {2}".format(self.public_key, origin, pprint.pformat(data)))
        self.stop()


if __name__ == "__main__":

    # create and connect the agent
    agent = WeatherClient("weather_client", oef_addr="127.0.0.1", oef_port=3333)
    agent.connect()

    # look for service agents registered as 'weather_station' that:
    # - provide measurements for temperature
    # - provide measurements for air pressure
    # - provide measurements for humidity
    query = Query([Constraint(TEMPERATURE_ATTR.name, Eq(True)),
                   Constraint(AIR_PRESSURE_ATTR.name, Eq(True)),
                   Constraint(HUMIDITY_ATTR.name, Eq(True))],
                  WEATHER_DATA_MODEL)

    agent.search_services_wide(44, query)

    try:
        agent.run()
    finally:
        agent.stop()
        agent.disconnect()