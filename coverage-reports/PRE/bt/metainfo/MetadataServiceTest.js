var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":130,"id":681,"methods":[{"el":42,"sc":5,"sl":39},{"el":56,"sc":5,"sl":44},{"el":70,"sc":5,"sl":58},{"el":88,"sc":5,"sl":72},{"el":113,"sc":5,"sl":90},{"el":129,"sc":5,"sl":114}],"name":"MetadataServiceTest","sl":35}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
