var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":93,"id":5697,"methods":[{"el":34,"sc":5,"sl":30},{"el":49,"sc":5,"sl":42},{"el":68,"sc":5,"sl":64},{"el":74,"sc":5,"sl":70},{"el":80,"sc":5,"sl":76},{"el":86,"sc":5,"sl":82},{"el":92,"sc":5,"sl":88}],"name":"Protocol_InsufficientDataTest","sl":22}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
