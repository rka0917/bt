var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":50,"id":5845,"methods":[{"el":31,"sc":5,"sl":28},{"el":37,"sc":5,"sl":33},{"el":43,"sc":5,"sl":39},{"el":49,"sc":5,"sl":45}],"name":"ProtocolsTest","sl":24}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
