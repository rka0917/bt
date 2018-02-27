var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":182,"id":2610,"methods":[{"el":42,"sc":5,"sl":33},{"el":54,"sc":5,"sl":44},{"el":66,"sc":5,"sl":56},{"el":79,"sc":5,"sl":68},{"el":95,"sc":5,"sl":83},{"el":110,"sc":5,"sl":97},{"el":124,"sc":5,"sl":112},{"el":139,"sc":5,"sl":126},{"el":153,"sc":5,"sl":141},{"el":169,"sc":5,"sl":155},{"el":181,"sc":5,"sl":171}],"name":"ReadWriteDataRange_SubrangeTest","sl":29}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_104":{"methods":[{"sl":126}],"name":"testSubrange_MultipleUnits_WithLength","pass":true,"statements":[{"sl":128},{"sl":129},{"sl":130},{"sl":131},{"sl":132},{"sl":134},{"sl":138}]},"test_107":{"methods":[{"sl":83}],"name":"testSubrange_MultipleUnits_Full","pass":true,"statements":[{"sl":85},{"sl":86},{"sl":87},{"sl":88},{"sl":90},{"sl":94}]},"test_120":{"methods":[{"sl":112}],"name":"testSubrange_MultipleUnits_WithOffsetInSecondUnit","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":120},{"sl":123}]},"test_123":{"methods":[{"sl":68}],"name":"testSubrange_SingleUnit_WithOffsetAndLength","pass":true,"statements":[{"sl":70},{"sl":71},{"sl":72},{"sl":73},{"sl":74},{"sl":75},{"sl":77},{"sl":78}]},"test_126":{"methods":[{"sl":56}],"name":"testSubrange_SingleUnit_WithLength","pass":true,"statements":[{"sl":58},{"sl":59},{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65}]},"test_127":{"methods":[{"sl":155}],"name":"testSubrange_MultipleUnits_WithOffsetAndLength","pass":true,"statements":[{"sl":157},{"sl":158},{"sl":159},{"sl":160},{"sl":161},{"sl":162},{"sl":164},{"sl":168}]},"test_13":{"methods":[{"sl":141}],"name":"testSubrange_MultipleUnits_WithLength_TrimLastUnit","pass":true,"statements":[{"sl":143},{"sl":144},{"sl":145},{"sl":146},{"sl":147},{"sl":149},{"sl":152}]},"test_130":{"methods":[{"sl":97}],"name":"testSubrange_MultipleUnits_WithOffset","pass":true,"statements":[{"sl":99},{"sl":100},{"sl":101},{"sl":102},{"sl":103},{"sl":105},{"sl":109}]},"test_132":{"methods":[{"sl":97}],"name":"testSubrange_MultipleUnits_WithOffset","pass":true,"statements":[{"sl":99},{"sl":100},{"sl":101},{"sl":102},{"sl":103},{"sl":105},{"sl":109}]},"test_134":{"methods":[{"sl":126}],"name":"testSubrange_MultipleUnits_WithLength","pass":true,"statements":[{"sl":128},{"sl":129},{"sl":130},{"sl":131},{"sl":132},{"sl":134},{"sl":138}]},"test_135":{"methods":[{"sl":83}],"name":"testSubrange_MultipleUnits_Full","pass":true,"statements":[{"sl":85},{"sl":86},{"sl":87},{"sl":88},{"sl":90},{"sl":94}]},"test_136":{"methods":[{"sl":141}],"name":"testSubrange_MultipleUnits_WithLength_TrimLastUnit","pass":true,"statements":[{"sl":143},{"sl":144},{"sl":145},{"sl":146},{"sl":147},{"sl":149},{"sl":152}]},"test_142":{"methods":[{"sl":141}],"name":"testSubrange_MultipleUnits_WithLength_TrimLastUnit","pass":true,"statements":[{"sl":143},{"sl":144},{"sl":145},{"sl":146},{"sl":147},{"sl":149},{"sl":152}]},"test_144":{"methods":[{"sl":171}],"name":"testSubrange_MultipleUnits_WithOffsetAndLength_TrimFirstAndLastUnits","pass":true,"statements":[{"sl":173},{"sl":174},{"sl":175},{"sl":176},{"sl":177},{"sl":179},{"sl":180}]},"test_145":{"methods":[{"sl":33}],"name":"testSubrange_SingleUnit_Full","pass":true,"statements":[{"sl":35},{"sl":36},{"sl":37},{"sl":38},{"sl":40},{"sl":41}]},"test_156":{"methods":[{"sl":126}],"name":"testSubrange_MultipleUnits_WithLength","pass":true,"statements":[{"sl":128},{"sl":129},{"sl":130},{"sl":131},{"sl":132},{"sl":134},{"sl":138}]},"test_158":{"methods":[{"sl":171}],"name":"testSubrange_MultipleUnits_WithOffsetAndLength_TrimFirstAndLastUnits","pass":true,"statements":[{"sl":173},{"sl":174},{"sl":175},{"sl":176},{"sl":177},{"sl":179},{"sl":180}]},"test_161":{"methods":[{"sl":83}],"name":"testSubrange_MultipleUnits_Full","pass":true,"statements":[{"sl":85},{"sl":86},{"sl":87},{"sl":88},{"sl":90},{"sl":94}]},"test_164":{"methods":[{"sl":68}],"name":"testSubrange_SingleUnit_WithOffsetAndLength","pass":true,"statements":[{"sl":70},{"sl":71},{"sl":72},{"sl":73},{"sl":74},{"sl":75},{"sl":77},{"sl":78}]},"test_166":{"methods":[{"sl":33}],"name":"testSubrange_SingleUnit_Full","pass":true,"statements":[{"sl":35},{"sl":36},{"sl":37},{"sl":38},{"sl":40},{"sl":41}]},"test_169":{"methods":[{"sl":44}],"name":"testSubrange_SingleUnit_WithOffset","pass":true,"statements":[{"sl":46},{"sl":47},{"sl":48},{"sl":49},{"sl":50},{"sl":52},{"sl":53}]},"test_179":{"methods":[{"sl":155}],"name":"testSubrange_MultipleUnits_WithOffsetAndLength","pass":true,"statements":[{"sl":157},{"sl":158},{"sl":159},{"sl":160},{"sl":161},{"sl":162},{"sl":164},{"sl":168}]},"test_189":{"methods":[{"sl":112}],"name":"testSubrange_MultipleUnits_WithOffsetInSecondUnit","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":120},{"sl":123}]},"test_190":{"methods":[{"sl":126}],"name":"testSubrange_MultipleUnits_WithLength","pass":true,"statements":[{"sl":128},{"sl":129},{"sl":130},{"sl":131},{"sl":132},{"sl":134},{"sl":138}]},"test_193":{"methods":[{"sl":33}],"name":"testSubrange_SingleUnit_Full","pass":true,"statements":[{"sl":35},{"sl":36},{"sl":37},{"sl":38},{"sl":40},{"sl":41}]},"test_197":{"methods":[{"sl":68}],"name":"testSubrange_SingleUnit_WithOffsetAndLength","pass":true,"statements":[{"sl":70},{"sl":71},{"sl":72},{"sl":73},{"sl":74},{"sl":75},{"sl":77},{"sl":78}]},"test_198":{"methods":[{"sl":56}],"name":"testSubrange_SingleUnit_WithLength","pass":true,"statements":[{"sl":58},{"sl":59},{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65}]},"test_199":{"methods":[{"sl":97}],"name":"testSubrange_MultipleUnits_WithOffset","pass":true,"statements":[{"sl":99},{"sl":100},{"sl":101},{"sl":102},{"sl":103},{"sl":105},{"sl":109}]},"test_2":{"methods":[{"sl":141}],"name":"testSubrange_MultipleUnits_WithLength_TrimLastUnit","pass":true,"statements":[{"sl":143},{"sl":144},{"sl":145},{"sl":146},{"sl":147},{"sl":149},{"sl":152}]},"test_201":{"methods":[{"sl":44}],"name":"testSubrange_SingleUnit_WithOffset","pass":true,"statements":[{"sl":46},{"sl":47},{"sl":48},{"sl":49},{"sl":50},{"sl":52},{"sl":53}]},"test_211":{"methods":[{"sl":112}],"name":"testSubrange_MultipleUnits_WithOffsetInSecondUnit","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":120},{"sl":123}]},"test_215":{"methods":[{"sl":56}],"name":"testSubrange_SingleUnit_WithLength","pass":true,"statements":[{"sl":58},{"sl":59},{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65}]},"test_226":{"methods":[{"sl":97}],"name":"testSubrange_MultipleUnits_WithOffset","pass":true,"statements":[{"sl":99},{"sl":100},{"sl":101},{"sl":102},{"sl":103},{"sl":105},{"sl":109}]},"test_28":{"methods":[{"sl":155}],"name":"testSubrange_MultipleUnits_WithOffsetAndLength","pass":true,"statements":[{"sl":157},{"sl":158},{"sl":159},{"sl":160},{"sl":161},{"sl":162},{"sl":164},{"sl":168}]},"test_4":{"methods":[{"sl":83}],"name":"testSubrange_MultipleUnits_Full","pass":true,"statements":[{"sl":85},{"sl":86},{"sl":87},{"sl":88},{"sl":90},{"sl":94}]},"test_57":{"methods":[{"sl":155}],"name":"testSubrange_MultipleUnits_WithOffsetAndLength","pass":true,"statements":[{"sl":157},{"sl":158},{"sl":159},{"sl":160},{"sl":161},{"sl":162},{"sl":164},{"sl":168}]},"test_63":{"methods":[{"sl":112}],"name":"testSubrange_MultipleUnits_WithOffsetInSecondUnit","pass":true,"statements":[{"sl":114},{"sl":115},{"sl":116},{"sl":117},{"sl":118},{"sl":120},{"sl":123}]},"test_7":{"methods":[{"sl":33}],"name":"testSubrange_SingleUnit_Full","pass":true,"statements":[{"sl":35},{"sl":36},{"sl":37},{"sl":38},{"sl":40},{"sl":41}]},"test_71":{"methods":[{"sl":171}],"name":"testSubrange_MultipleUnits_WithOffsetAndLength_TrimFirstAndLastUnits","pass":true,"statements":[{"sl":173},{"sl":174},{"sl":175},{"sl":176},{"sl":177},{"sl":179},{"sl":180}]},"test_74":{"methods":[{"sl":68}],"name":"testSubrange_SingleUnit_WithOffsetAndLength","pass":true,"statements":[{"sl":70},{"sl":71},{"sl":72},{"sl":73},{"sl":74},{"sl":75},{"sl":77},{"sl":78}]},"test_76":{"methods":[{"sl":44}],"name":"testSubrange_SingleUnit_WithOffset","pass":true,"statements":[{"sl":46},{"sl":47},{"sl":48},{"sl":49},{"sl":50},{"sl":52},{"sl":53}]},"test_9":{"methods":[{"sl":171}],"name":"testSubrange_MultipleUnits_WithOffsetAndLength_TrimFirstAndLastUnits","pass":true,"statements":[{"sl":173},{"sl":174},{"sl":175},{"sl":176},{"sl":177},{"sl":179},{"sl":180}]},"test_96":{"methods":[{"sl":56}],"name":"testSubrange_SingleUnit_WithLength","pass":true,"statements":[{"sl":58},{"sl":59},{"sl":60},{"sl":61},{"sl":62},{"sl":64},{"sl":65}]},"test_97":{"methods":[{"sl":44}],"name":"testSubrange_SingleUnit_WithOffset","pass":true,"statements":[{"sl":46},{"sl":47},{"sl":48},{"sl":49},{"sl":50},{"sl":52},{"sl":53}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [166, 7, 193, 145], [], [166, 7, 193, 145], [166, 7, 193, 145], [166, 7, 193, 145], [166, 7, 193, 145], [], [166, 7, 193, 145], [166, 7, 193, 145], [], [], [76, 97, 201, 169], [], [76, 97, 201, 169], [76, 97, 201, 169], [76, 97, 201, 169], [76, 97, 201, 169], [76, 97, 201, 169], [], [76, 97, 201, 169], [76, 97, 201, 169], [], [], [198, 126, 215, 96], [], [198, 126, 215, 96], [198, 126, 215, 96], [198, 126, 215, 96], [198, 126, 215, 96], [198, 126, 215, 96], [], [198, 126, 215, 96], [198, 126, 215, 96], [], [], [197, 123, 74, 164], [], [197, 123, 74, 164], [197, 123, 74, 164], [197, 123, 74, 164], [197, 123, 74, 164], [197, 123, 74, 164], [197, 123, 74, 164], [], [197, 123, 74, 164], [197, 123, 74, 164], [], [], [], [], [161, 135, 4, 107], [], [161, 135, 4, 107], [161, 135, 4, 107], [161, 135, 4, 107], [161, 135, 4, 107], [], [161, 135, 4, 107], [], [], [], [161, 135, 4, 107], [], [], [226, 132, 130, 199], [], [226, 132, 130, 199], [226, 132, 130, 199], [226, 132, 130, 199], [226, 132, 130, 199], [226, 132, 130, 199], [], [226, 132, 130, 199], [], [], [], [226, 132, 130, 199], [], [], [63, 120, 189, 211], [], [63, 120, 189, 211], [63, 120, 189, 211], [63, 120, 189, 211], [63, 120, 189, 211], [63, 120, 189, 211], [], [63, 120, 189, 211], [], [], [63, 120, 189, 211], [], [], [134, 156, 104, 190], [], [134, 156, 104, 190], [134, 156, 104, 190], [134, 156, 104, 190], [134, 156, 104, 190], [134, 156, 104, 190], [], [134, 156, 104, 190], [], [], [], [134, 156, 104, 190], [], [], [136, 2, 13, 142], [], [136, 2, 13, 142], [136, 2, 13, 142], [136, 2, 13, 142], [136, 2, 13, 142], [136, 2, 13, 142], [], [136, 2, 13, 142], [], [], [136, 2, 13, 142], [], [], [179, 57, 127, 28], [], [179, 57, 127, 28], [179, 57, 127, 28], [179, 57, 127, 28], [179, 57, 127, 28], [179, 57, 127, 28], [179, 57, 127, 28], [], [179, 57, 127, 28], [], [], [], [179, 57, 127, 28], [], [], [158, 9, 71, 144], [], [158, 9, 71, 144], [158, 9, 71, 144], [158, 9, 71, 144], [158, 9, 71, 144], [158, 9, 71, 144], [], [158, 9, 71, 144], [158, 9, 71, 144], [], []]
