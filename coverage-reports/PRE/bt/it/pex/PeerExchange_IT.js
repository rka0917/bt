var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":178,"id":12991,"methods":[{"el":59,"sc":17,"sl":56},{"el":63,"sc":17,"sl":60},{"el":67,"sc":17,"sl":64},{"el":73,"sc":17,"sl":70},{"el":77,"sc":17,"sl":74},{"el":127,"sc":5,"sl":86},{"el":131,"sc":5,"sl":129}],"name":"PeerExchange_IT","sl":47},{"el":177,"id":13032,"methods":[{"el":149,"sc":9,"sl":142},{"el":176,"sc":9,"sl":151}],"name":"PeerExchange_IT.PEXPeerFilter","sl":137}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
