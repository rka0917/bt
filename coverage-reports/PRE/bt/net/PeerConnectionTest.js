var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":191,"id":11345,"methods":[{"el":83,"sc":5,"sl":70},{"el":110,"sc":5,"sl":85},{"el":120,"sc":5,"sl":112},{"el":130,"sc":5,"sl":122}],"name":"PeerConnectionTest","sl":59},{"el":190,"id":11382,"methods":[{"el":142,"sc":9,"sl":139},{"el":154,"sc":9,"sl":144},{"el":164,"sc":9,"sl":156},{"el":173,"sc":9,"sl":166},{"el":189,"sc":9,"sl":175}],"name":"PeerConnectionTest.Server","sl":132}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
