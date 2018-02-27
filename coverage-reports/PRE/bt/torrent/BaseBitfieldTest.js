var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":99,"id":11963,"methods":[{"el":35,"sc":5,"sl":31},{"el":46,"sc":13,"sl":43},{"el":51,"sc":13,"sl":48},{"el":56,"sc":13,"sl":53},{"el":61,"sc":13,"sl":58},{"el":66,"sc":13,"sl":63},{"el":71,"sc":13,"sl":68},{"el":81,"sc":13,"sl":73},{"el":91,"sc":13,"sl":83},{"el":96,"sc":13,"sl":93},{"el":98,"sc":5,"sl":37}],"name":"BaseBitfieldTest","sl":25}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
