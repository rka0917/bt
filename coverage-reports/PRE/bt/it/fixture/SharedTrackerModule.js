var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":278,"id":13204,"methods":[{"el":77,"sc":5,"sl":75},{"el":87,"sc":5,"sl":85},{"el":92,"sc":5,"sl":89},{"el":98,"sc":5,"sl":94}],"name":"SharedTrackerModule","sl":47},{"el":65,"id":13204,"methods":[],"name":"SharedTrackerModule.PeerFilter","sl":54},{"el":107,"id":13212,"methods":[{"el":106,"sc":9,"sl":102}],"name":"SharedTrackerModule.DefaultPeerFilter","sl":100},{"el":198,"id":13215,"methods":[{"el":122,"sc":9,"sl":117},{"el":127,"sc":9,"sl":124},{"el":141,"sc":33,"sl":137},{"el":147,"sc":33,"sl":143},{"el":152,"sc":33,"sl":149},{"el":157,"sc":33,"sl":154},{"el":162,"sc":33,"sl":159},{"el":168,"sc":21,"sl":165},{"el":178,"sc":9,"sl":129},{"el":189,"sc":9,"sl":180},{"el":197,"sc":9,"sl":191}],"name":"SharedTrackerModule.PeerTrackerService","sl":109},{"el":253,"id":13263,"methods":[{"el":210,"sc":9,"sl":207},{"el":225,"sc":9,"sl":212},{"el":239,"sc":9,"sl":227},{"el":252,"sc":9,"sl":241}],"name":"SharedTrackerModule.KnownPeersService","sl":202},{"el":277,"id":13297,"methods":[{"el":261,"sc":9,"sl":259},{"el":266,"sc":9,"sl":263},{"el":271,"sc":9,"sl":268},{"el":276,"sc":9,"sl":273}],"name":"SharedTrackerModule.StartResponse","sl":255}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
