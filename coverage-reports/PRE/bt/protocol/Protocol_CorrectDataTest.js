var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":221,"id":5641,"methods":[{"el":51,"sc":5,"sl":41},{"el":63,"sc":5,"sl":53},{"el":85,"sc":5,"sl":82},{"el":90,"sc":5,"sl":87},{"el":95,"sc":5,"sl":92},{"el":100,"sc":5,"sl":97},{"el":105,"sc":5,"sl":102},{"el":110,"sc":5,"sl":107},{"el":115,"sc":5,"sl":112},{"el":120,"sc":5,"sl":117},{"el":125,"sc":5,"sl":122},{"el":130,"sc":5,"sl":127},{"el":157,"sc":5,"sl":152},{"el":164,"sc":5,"sl":159},{"el":171,"sc":5,"sl":166},{"el":178,"sc":5,"sl":173},{"el":185,"sc":5,"sl":180},{"el":192,"sc":5,"sl":187},{"el":199,"sc":5,"sl":194},{"el":206,"sc":5,"sl":201},{"el":213,"sc":5,"sl":208},{"el":220,"sc":5,"sl":215}],"name":"Protocol_CorrectDataTest","sl":24}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
