var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":311,"id":12724,"methods":[{"el":48,"sc":5,"sl":45},{"el":155,"sc":5,"sl":145},{"el":167,"sc":5,"sl":157},{"el":185,"sc":5,"sl":169},{"el":203,"sc":5,"sl":187},{"el":215,"sc":5,"sl":205},{"el":226,"sc":5,"sl":217},{"el":237,"sc":5,"sl":228},{"el":255,"sc":5,"sl":239},{"el":273,"sc":5,"sl":257},{"el":287,"sc":5,"sl":275},{"el":299,"sc":13,"sl":292},{"el":308,"sc":13,"sl":301},{"el":310,"sc":5,"sl":289}],"name":"MessagingAgentCompilerTest","sl":41},{"el":62,"id":12726,"methods":[{"el":56,"sc":9,"sl":54},{"el":61,"sc":9,"sl":58}],"name":"MessagingAgentCompilerTest.C1","sl":50},{"el":74,"id":12730,"methods":[{"el":67,"sc":9,"sl":66},{"el":70,"sc":9,"sl":69},{"el":73,"sc":9,"sl":72}],"name":"MessagingAgentCompilerTest.C2","sl":64},{"el":88,"id":12733,"methods":[{"el":82,"sc":9,"sl":80},{"el":87,"sc":9,"sl":84}],"name":"MessagingAgentCompilerTest.C3","sl":76},{"el":94,"id":12737,"methods":[{"el":93,"sc":9,"sl":92}],"name":"MessagingAgentCompilerTest.C4","sl":90},{"el":98,"id":12738,"methods":[],"name":"MessagingAgentCompilerTest.C5","sl":96},{"el":112,"id":12738,"methods":[{"el":106,"sc":9,"sl":104},{"el":111,"sc":9,"sl":108}],"name":"MessagingAgentCompilerTest.P1","sl":100},{"el":129,"id":12742,"methods":[{"el":120,"sc":9,"sl":118},{"el":123,"sc":9,"sl":122},{"el":128,"sc":9,"sl":125}],"name":"MessagingAgentCompilerTest.P2","sl":114},{"el":143,"id":12747,"methods":[{"el":137,"sc":9,"sl":135},{"el":142,"sc":9,"sl":139}],"name":"MessagingAgentCompilerTest.P3","sl":131}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
