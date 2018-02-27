var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":207,"id":8339,"methods":[{"el":47,"sc":5,"sl":41},{"el":78,"sc":5,"sl":55},{"el":87,"sc":5,"sl":80},{"el":116,"sc":5,"sl":89},{"el":138,"sc":5,"sl":118},{"el":143,"sc":5,"sl":140},{"el":147,"sc":5,"sl":145}],"name":"MultiTrackerTest","sl":33},{"el":206,"id":8403,"methods":[{"el":165,"sc":17,"sl":162},{"el":170,"sc":17,"sl":167},{"el":175,"sc":17,"sl":172},{"el":180,"sc":17,"sl":177},{"el":185,"sc":17,"sl":182},{"el":187,"sc":9,"sl":156},{"el":192,"sc":9,"sl":189},{"el":196,"sc":9,"sl":194},{"el":200,"sc":9,"sl":198},{"el":205,"sc":9,"sl":202}],"name":"MultiTrackerTest.StoppableTracker","sl":149}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
