var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":177,"id":4431,"methods":[{"el":66,"sc":5,"sl":56},{"el":70,"sc":5,"sl":68},{"el":93,"sc":5,"sl":72},{"el":125,"sc":5,"sl":95},{"el":129,"sc":5,"sl":127},{"el":137,"sc":5,"sl":131},{"el":147,"sc":5,"sl":139},{"el":162,"sc":5,"sl":149},{"el":167,"sc":5,"sl":164},{"el":176,"sc":5,"sl":169}],"name":"SingleClientUdpTracker","sl":36}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
