var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":142,"id":1690,"methods":[{"el":52,"sc":5,"sl":48},{"el":58,"sc":5,"sl":54},{"el":66,"sc":5,"sl":63},{"el":71,"sc":5,"sl":68},{"el":76,"sc":5,"sl":73},{"el":81,"sc":5,"sl":78},{"el":86,"sc":5,"sl":83},{"el":91,"sc":5,"sl":88},{"el":96,"sc":5,"sl":93},{"el":101,"sc":5,"sl":98},{"el":106,"sc":5,"sl":103},{"el":128,"sc":5,"sl":118},{"el":141,"sc":5,"sl":133}],"name":"AnnounceMessageTest","sl":30}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
