var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":167,"id":7122,"methods":[{"el":54,"sc":56,"sl":51},{"el":59,"sc":5,"sl":46},{"el":150,"sc":5,"sl":146},{"el":156,"sc":5,"sl":152},{"el":166,"sc":5,"sl":158}],"name":"RoutingPeerWorker_WithCompilerTest","sl":40},{"el":64,"id":7132,"methods":[],"name":"RoutingPeerWorker_WithCompilerTest.Executable","sl":61},{"el":110,"id":7132,"methods":[{"el":77,"sc":51,"sl":72},{"el":79,"sc":9,"sl":71},{"el":84,"sc":9,"sl":81},{"el":89,"sc":9,"sl":86},{"el":94,"sc":9,"sl":91},{"el":99,"sc":9,"sl":96},{"el":104,"sc":9,"sl":101},{"el":109,"sc":9,"sl":106}],"name":"RoutingPeerWorker_WithCompilerTest.C1","sl":66},{"el":144,"id":7152,"methods":[{"el":121,"sc":51,"sl":118},{"el":123,"sc":9,"sl":117},{"el":128,"sc":9,"sl":125},{"el":133,"sc":9,"sl":130},{"el":138,"sc":9,"sl":135},{"el":143,"sc":9,"sl":140}],"name":"RoutingPeerWorker_WithCompilerTest.P1","sl":112}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
