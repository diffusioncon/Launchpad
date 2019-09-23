import os
import time

from squid_py import (
    Ocean,
    ConfigProvider,
    Config,
    Metadata,
    Account
)

ConfigProvider.set_config(Config('config.ini'))
# Make a new instance of Ocean
ocean = Ocean() # or Ocean(Config('config.ini'))
config = ocean.config
# make account instance, assuming the ethereum account and password are set 
# in the config file `config.ini`
account = ocean.accounts.list()[0]
# or 
account = Account(config.parity_address, config.parity_password)

# PUBLISHER
# Let's start by registering an asset in the Ocean network
metadata = Metadata.get_example()

# consume and service endpoints require `brizo.url` is set in the config file
# or passed to Ocean instance in the config_dict.
# define the services to include in the new asset DDO

ddo = ocean.assets.create(metadata, account)

# Now we have an asset registered, we can verify it exists by resolving the did
_ddo = ocean.assets.resolve(ddo.did)
# ddo and _ddo should be identical

# CONSUMER
# search for assets
asset_ddo = ocean.assets.search('Ocean protocol')[0]
# Need some ocean tokens to be able to order assets
ocean.accounts.request_tokens(account, 10)

# Start the purchase/consume request. This will automatically make a payment from the specified account.
consumer_account = ocean.accounts.list()[1]
service_agreement_id = ocean.assets.order(asset_ddo.did, 0, consumer_account)

# after a short wait (seconds to minutes) the asset data files should be available in the `downloads.path` defined in config
# wait a bit to let things happen
time.sleep(20)

# Asset files are saved in a folder named after the asset id
dataset_dir = os.path.join(ocean.config.downloads_path, f'datafile.{asset_ddo.asset_id}.0')
if os.path.exists(dataset_dir):
    print('asset files downloaded: {}'.format(os.listdir(dataset_dir)))