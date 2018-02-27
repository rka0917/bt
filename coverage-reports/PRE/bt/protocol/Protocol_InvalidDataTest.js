var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":269,"id":5715,"methods":[{"el":53,"sc":5,"sl":37},{"el":70,"sc":5,"sl":57},{"el":97,"sc":5,"sl":84},{"el":112,"sc":5,"sl":99},{"el":127,"sc":5,"sl":114},{"el":142,"sc":5,"sl":129},{"el":166,"sc":5,"sl":153},{"el":181,"sc":5,"sl":168},{"el":196,"sc":5,"sl":183},{"el":223,"sc":5,"sl":210},{"el":238,"sc":5,"sl":225},{"el":253,"sc":5,"sl":240},{"el":268,"sc":5,"sl":255}],"name":"Protocol_InvalidDataTest","sl":28}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
