var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":104,"id":13305,"methods":[{"el":48,"sc":5,"sl":45},{"el":56,"sc":5,"sl":54},{"el":64,"sc":5,"sl":62},{"el":72,"sc":5,"sl":70},{"el":80,"sc":5,"sl":78},{"el":85,"sc":5,"sl":82},{"el":103,"sc":5,"sl":87}],"name":"Swarm","sl":38}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
