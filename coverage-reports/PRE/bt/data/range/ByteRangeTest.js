var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":151,"id":283,"methods":[{"el":40,"sc":5,"sl":34},{"el":48,"sc":5,"sl":42},{"el":56,"sc":5,"sl":50},{"el":64,"sc":5,"sl":58},{"el":72,"sc":5,"sl":66},{"el":80,"sc":5,"sl":74},{"el":90,"sc":5,"sl":86},{"el":96,"sc":5,"sl":92},{"el":118,"sc":5,"sl":102},{"el":150,"sc":5,"sl":120}],"name":"ByteRangeTest","sl":28}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
