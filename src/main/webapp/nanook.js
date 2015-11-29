var AeshHandler = Java.type('org.jboss.aesh.nanook.util.AeshHandler');
var aesh = new AeshHandler();

$undertow.onGet('/nanook',
  {headers: {'content-type': 'text/plain'}},
  [

    function($exchange) {
      var result = aesh.run($exchange.param('command'));
      aesh.reset();
      return result;
    }

  ]
);