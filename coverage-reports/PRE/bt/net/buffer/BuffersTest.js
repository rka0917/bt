var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":165,"id":5094,"methods":[{"el":37,"sc":5,"sl":31},{"el":45,"sc":5,"sl":39},{"el":53,"sc":5,"sl":47},{"el":61,"sc":5,"sl":55},{"el":69,"sc":5,"sl":63},{"el":77,"sc":5,"sl":71},{"el":85,"sc":5,"sl":79},{"el":93,"sc":5,"sl":87},{"el":101,"sc":5,"sl":95},{"el":109,"sc":5,"sl":103},{"el":117,"sc":5,"sl":111},{"el":125,"sc":5,"sl":119},{"el":133,"sc":5,"sl":127},{"el":141,"sc":5,"sl":135},{"el":149,"sc":5,"sl":143},{"el":157,"sc":5,"sl":151},{"el":164,"sc":5,"sl":159}],"name":"BuffersTest","sl":29}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
