var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":89,"id":4802,"methods":[{"el":33,"sc":5,"sl":30},{"el":38,"sc":5,"sl":35},{"el":43,"sc":5,"sl":40},{"el":48,"sc":5,"sl":45},{"el":53,"sc":5,"sl":50},{"el":58,"sc":5,"sl":55},{"el":63,"sc":5,"sl":60},{"el":68,"sc":5,"sl":65},{"el":73,"sc":5,"sl":70},{"el":78,"sc":5,"sl":75},{"el":83,"sc":5,"sl":80},{"el":88,"sc":5,"sl":85}],"name":"MockFileSystem","sl":29}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
