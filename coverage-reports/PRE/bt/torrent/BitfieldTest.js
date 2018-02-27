var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":226,"id":11841,"methods":[{"el":100,"sc":5,"sl":40},{"el":176,"sc":5,"sl":102},{"el":215,"sc":5,"sl":178},{"el":225,"sc":5,"sl":217}],"name":"BitfieldTest","sl":38}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
