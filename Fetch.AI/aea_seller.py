import json
import pprint

from aea_schema import WEATHER_DATA_MODEL
from oef.agents import OEFAgent
from oef.messages import CFP_TYPES
from oef.schema import Description


class WeatherStation(OEFAgent):
    """Class that implements the behaviour of the weather station."""

    weather_service_description = Description(
        {
            "wind_speed": False,
            "temperature": True,
            "air_pressure": True,
            "humidity": True,
        },
        WEATHER_DATA_MODEL
    )

    def on_cfp(self, msg_id: int, dialogue_id: int, origin: str, target: int, query: CFP_TYPES):
        """Send a simple Propose to the sender of the CFP."""
        print("[{0}]: Received CFP from {1}".format(self.public_key, origin))

        # prepare the proposal with a given price.
        price = 50
        proposal = Description({"price": price})
        print("[{}]: Sending propose at price: {}".format(self.public_key, price))
        self.send_propose(msg_id + 1, dialogue_id, origin, target + 1, [proposal])

    def on_accept(self, msg_id: int, dialogue_id: int, origin: str, target: int):
        """Once we received an Accept, send the requested data."""
        print("[{0}]: Received accept from {1}."
              .format(self.public_key, origin))

        # send the measurements to the client. for the sake of simplicity, they are hard-coded.
        data = {"temperature": 15.0, "humidity": 0.7, "air_pressure": 1019.0}
        encoded_data = json.dumps(data).encode("utf-8")
        print("[{0}]: Sending data to {1}: {2}".format(self.public_key, origin, pprint.pformat(data)))
        self.send_message(0, dialogue_id, origin, encoded_data)


if __name__ == "__main__":
    agent = WeatherStation("weather_station", oef_addr="127.0.0.1", oef_port=3333)
    agent.connect()
    agent.register_service(77, agent.weather_service_description)

    print("[{}]: Waiting for clients...".format(agent.public_key))
    try:
        agent.run()
    finally:
        agent.stop()
        agent.disconnect()