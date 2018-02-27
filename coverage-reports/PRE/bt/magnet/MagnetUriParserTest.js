var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":124,"id":7538,"methods":[{"el":60,"sc":5,"sl":34},{"el":71,"sc":5,"sl":62},{"el":84,"sc":5,"sl":73},{"el":97,"sc":5,"sl":86},{"el":108,"sc":5,"sl":99},{"el":123,"sc":5,"sl":110}],"name":"MagnetUriParserTest","sl":32}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
