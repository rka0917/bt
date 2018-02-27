var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":144,"id":11026,"methods":[{"el":54,"sc":5,"sl":38},{"el":76,"sc":5,"sl":56},{"el":93,"sc":5,"sl":78},{"el":110,"sc":5,"sl":95},{"el":127,"sc":5,"sl":112},{"el":139,"sc":5,"sl":129},{"el":143,"sc":5,"sl":141}],"name":"ByteChannelReader_TimedReadTest","sl":33}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_109":{"methods":[{"sl":38},{"sl":129},{"sl":141}],"name":"testReader_timedRead_ExactAmount_SingleBlock","pass":true,"statements":[{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":46},{"sl":47},{"sl":48},{"sl":50},{"sl":51},{"sl":52},{"sl":53},{"sl":130},{"sl":131},{"sl":132},{"sl":134},{"sl":135},{"sl":137},{"sl":138},{"sl":142}]},"test_160":{"methods":[{"sl":56},{"sl":129},{"sl":141}],"name":"testReader_timedRead_ExactAmount_MultipleBlocks","pass":true,"statements":[{"sl":58},{"sl":59},{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65},{"sl":66},{"sl":68},{"sl":69},{"sl":70},{"sl":72},{"sl":73},{"sl":74},{"sl":75},{"sl":130},{"sl":131},{"sl":132},{"sl":134},{"sl":135},{"sl":137},{"sl":138},{"sl":142}]},"test_192":{"methods":[{"sl":78},{"sl":129},{"sl":141}],"name":"testReader_timedRead_InsufficientDataRead","pass":true,"statements":[{"sl":80},{"sl":81},{"sl":82},{"sl":83},{"sl":84},{"sl":86},{"sl":87},{"sl":88},{"sl":130},{"sl":131},{"sl":132},{"sl":134},{"sl":135},{"sl":137},{"sl":138},{"sl":142}]},"test_196":{"methods":[{"sl":38},{"sl":129},{"sl":141}],"name":"testReader_timedRead_ExactAmount_SingleBlock","pass":true,"statements":[{"sl":40},{"sl":41},{"sl":42},{"sl":43},{"sl":44},{"sl":46},{"sl":47},{"sl":48},{"sl":50},{"sl":51},{"sl":52},{"sl":53},{"sl":130},{"sl":131},{"sl":132},{"sl":134},{"sl":135},{"sl":137},{"sl":138},{"sl":142}]},"test_202":{"methods":[{"sl":95},{"sl":129},{"sl":141}],"name":"testReader_timedRead_ExcessiveDataRead","pass":true,"statements":[{"sl":97},{"sl":98},{"sl":99},{"sl":100},{"sl":101},{"sl":103},{"sl":104},{"sl":105},{"sl":130},{"sl":131},{"sl":132},{"sl":134},{"sl":135},{"sl":137},{"sl":138},{"sl":142}]},"test_207":{"methods":[{"sl":112},{"sl":129},{"sl":141}],"name":"testReader_timedRead_EOF","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":120},{"sl":121},{"sl":122},{"sl":130},{"sl":131},{"sl":132},{"sl":134},{"sl":135},{"sl":137},{"sl":138},{"sl":142}]},"test_217":{"methods":[{"sl":112},{"sl":129},{"sl":141}],"name":"testReader_timedRead_EOF","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":120},{"sl":121},{"sl":122},{"sl":130},{"sl":131},{"sl":132},{"sl":134},{"sl":135},{"sl":137},{"sl":138},{"sl":142}]},"test_5":{"methods":[{"sl":95},{"sl":129},{"sl":141}],"name":"testReader_timedRead_ExcessiveDataRead","pass":true,"statements":[{"sl":97},{"sl":98},{"sl":99},{"sl":100},{"sl":101},{"sl":103},{"sl":104},{"sl":105},{"sl":130},{"sl":131},{"sl":132},{"sl":134},{"sl":135},{"sl":137},{"sl":138},{"sl":142}]},"test_50":{"methods":[{"sl":56},{"sl":129},{"sl":141}],"name":"testReader_timedRead_ExactAmount_MultipleBlocks","pass":true,"statements":[{"sl":58},{"sl":59},{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65},{"sl":66},{"sl":68},{"sl":69},{"sl":70},{"sl":72},{"sl":73},{"sl":74},{"sl":75},{"sl":130},{"sl":131},{"sl":132},{"sl":134},{"sl":135},{"sl":137},{"sl":138},{"sl":142}]},"test_90":{"methods":[{"sl":78},{"sl":129},{"sl":141}],"name":"testReader_timedRead_InsufficientDataRead","pass":true,"statements":[{"sl":80},{"sl":81},{"sl":82},{"sl":83},{"sl":84},{"sl":86},{"sl":87},{"sl":88},{"sl":130},{"sl":131},{"sl":132},{"sl":134},{"sl":135},{"sl":137},{"sl":138},{"sl":142}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [109, 196], [], [109, 196], [109, 196], [109, 196], [109, 196], [109, 196], [], [109, 196], [109, 196], [109, 196], [], [109, 196], [109, 196], [109, 196], [109, 196], [], [], [50, 160], [], [50, 160], [50, 160], [50, 160], [50, 160], [50, 160], [], [50, 160], [50, 160], [50, 160], [], [50, 160], [50, 160], [50, 160], [], [50, 160], [50, 160], [50, 160], [50, 160], [], [], [90, 192], [], [90, 192], [90, 192], [90, 192], [90, 192], [90, 192], [], [90, 192], [90, 192], [90, 192], [], [], [], [], [], [], [202, 5], [], [202, 5], [202, 5], [202, 5], [202, 5], [202, 5], [], [202, 5], [202, 5], [202, 5], [], [], [], [], [], [], [207, 217], [], [207, 217], [207, 217], [207, 217], [207, 217], [207, 217], [], [207, 217], [207, 217], [207, 217], [], [], [], [], [], [], [109, 90, 202, 192, 196, 5, 50, 160, 207, 217], [109, 90, 202, 192, 196, 5, 50, 160, 207, 217], [109, 90, 202, 192, 196, 5, 50, 160, 207, 217], [109, 90, 202, 192, 196, 5, 50, 160, 207, 217], [], [109, 90, 202, 192, 196, 5, 50, 160, 207, 217], [109, 90, 202, 192, 196, 5, 50, 160, 207, 217], [], [109, 90, 202, 192, 196, 5, 50, 160, 207, 217], [109, 90, 202, 192, 196, 5, 50, 160, 207, 217], [], [], [109, 90, 202, 192, 196, 5, 50, 160, 207, 217], [109, 90, 202, 192, 196, 5, 50, 160, 207, 217], [], []]
