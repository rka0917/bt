var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":115,"id":13102,"methods":[{"el":64,"sc":5,"sl":50},{"el":79,"sc":5,"sl":72},{"el":83,"sc":5,"sl":81},{"el":87,"sc":5,"sl":85}],"name":"BaseBtTest","sl":38},{"el":114,"id":13122,"methods":[{"el":101,"sc":9,"sl":98},{"el":113,"sc":9,"sl":103}],"name":"BaseBtTest.CachingTorrentSupplier","sl":92}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
