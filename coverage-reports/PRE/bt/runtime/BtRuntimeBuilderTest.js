var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":120,"id":12428,"methods":[{"el":44,"sc":5,"sl":38},{"el":54,"sc":5,"sl":46},{"el":62,"sc":5,"sl":56},{"el":82,"sc":5,"sl":74},{"el":106,"sc":5,"sl":98},{"el":112,"sc":5,"sl":108},{"el":119,"sc":5,"sl":114}],"name":"BtRuntimeBuilderTest","sl":31},{"el":34,"id":12428,"methods":[],"name":"BtRuntimeBuilderTest.I1","sl":33},{"el":36,"id":12428,"methods":[],"name":"BtRuntimeBuilderTest.S1","sl":35},{"el":72,"id":12443,"methods":[{"el":71,"sc":9,"sl":68}],"name":"BtRuntimeBuilderTest.AnotherOverridenApplicationService","sl":64},{"el":86,"id":12451,"methods":[],"name":"BtRuntimeBuilderTest.IConfigHolder","sl":84},{"el":96,"id":12451,"methods":[{"el":95,"sc":9,"sl":92}],"name":"BtRuntimeBuilderTest.ConfigHolder","sl":88}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
