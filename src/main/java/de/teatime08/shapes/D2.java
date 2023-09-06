package de.teatime08.shapes;

import de.teatime08.Cell;

import java.util.HashSet;
import java.util.Set;

import static de.teatime08.shapes.IStringIO.fromConwaysNotation;
import static de.teatime08.shapes.IStringIO.fromString;

public abstract class D2 {

    public final static Set<Cell> BLINKER = new HashSet<>() {{
        add(Cell.of(new int[]{1, 1}));
        add(Cell.of(new int[]{1, 2}));
        add(Cell.of(new int[]{1, 3}));
    }};

    public final static Set<Cell> BLOCK = new HashSet<>() {{
        add(Cell.of(new int[]{1, 1}));
        add(Cell.of(new int[]{1, 2}));
        add(Cell.of(new int[]{2, 1}));
        add(Cell.of(new int[]{2, 2}));
    }};

    public final static Set<Cell> GLIDER = new HashSet<>() {{
        add(Cell.of(new int[]{3, 0}));
        add(Cell.of(new int[]{1, 1}));
        add(Cell.of(new int[]{3, 1}));
        add(Cell.of(new int[]{2, 2}));
        add(Cell.of(new int[]{3, 2}));
    }};

    public final static Set<Cell> BEEHIVE = fromString(
        "(0, 1), (0, 2), (1, 0), (1, 3), (2, 1), (2, 2)"
    );
    public final static Set<Cell> LWSS = fromString(
        "(0, 0), (0, 3), (1, 4), (2, 0), (2, 4), (3, 1), (3, 2), (3, 3), (3, 4)"
    );
    public final static Set<Cell> LOAF = fromString(
        "(0, 1), (0, 2), (1, 0), (1, 3), (2, 1), (2, 3), (3, 2)"
    );

    public final static Set<Cell> METHUSELAH_R_PENTOMINO = fromString(
        "(-1, 0), (-1, 1), (0, -1), (0, 0), (1, 0)"
    );

    public final static Set<Cell> GOSPER_GLIDER_GUN = fromString(
        "(0, 24), (1, 22), (1, 24), (2, 12), (2, 13), (2, 20), (2, 21), (2, 34), (2, 35)," +
        "(3, 11), (3, 15), (3, 20), (3, 21), (3, 34), (3, 35), (4, 0), (4, 1), (4, 10)," +
        "(4, 16), (4, 20), (4, 21), (5, 0), (5, 1), (5, 10), (5, 14), (5, 16), (5, 17)," +
        "(5, 22), (5, 24), (6, 10), (6, 16), (6, 24), (7, 11), (7, 15), (8, 12), (8, 13)"
    );
    public final static Set<Cell> PULSAR = fromString(
        "(1, 2), (1, 3), (1, 4), (1, 8), (1, 9), (1, 10), (3, 0), (3, 5), (3, 7), (3, 12)," +
        "(4, 0), (4, 5), (4, 7), (4, 12), (5, 0), (5, 5), (5, 7), (5, 12), (6, 2), (6, 3)," +
        "(6, 4), (6, 8), (6, 9), (6, 10), (8, 2), (8, 3), (8, 4), (8, 8), (8, 9), (8, 10)," +
        "(9, 0), (9, 5), (9, 7), (9, 12), (10, 0), (10, 5), (10, 7), (10, 12), (11, 0)," +
        "(11, 5), (11, 7), (11, 12), (13, 2), (13, 3), (13, 4), (13, 8), (13, 9), (13, 10)," +
        "(14, 2), (14, 3), (14, 4), (14, 8), (14, 9), (14, 10)"
    );
    public final static Set<Cell> LARGE_GOSPER_GLIDER_GUN = fromString(
        "(0, 36), (0, 37), (1, 36), (1, 37)," +
            "(8, 24), (8, 25), (9, 24), (9, 25)," +
            "(6, 12), (6, 13), (7, 12), (7, 13), (8, 12), (8, 13)," +
            "(10, 0), (10, 1), (11, 0), (11, 1), (12, 0), (12, 1)," +
            "(16, 24), (16, 25), (17, 24), (17, 25), (18, 24), (18, 25)," +
            "(16, 12), (16, 13), (17, 12), (17, 13), (18, 12), (18, 13)," +
            "(20, 36), (20, 37), (21, 36), (21, 37)," +
            "(24, 36), (24, 37), (25, 36), (25, 37), (26, 36), (26, 37)," +
            "(22, 48), (22, 49), (23, 48), (23, 49)"
    );

    public final static Set<Cell> PUFFER_TRAIN = fromString(
    "(0, 1), (0, 2), (1, 0), (1, 1), (1, 2), (1, 3), (1, 4), (2, 5), (3, 0),\n" +
        "(3, 5), (4, 5), (5, 5), (6, 4), (7, 0), (7, 4), (9, 1), (9, 2), (10, 0),\n" +
        "(10, 1), (10, 2), (11, 1), (14, 10), (14, 11), (15, 10), (15, 12), (17, 12),\n" +
        "(18, 12), (19, 11), (19, 15), (20, 11), (21, 12), (22, 11), (22, 12),\n" +
        "(23, 11), (24, 10), (25, 8), (25, 9), (26, 8), (27, 10), (29, 8), (30, 8),\n" +
        "(31, 7), (31, 8), (32, 7), (32, 9), (33, 7), (33, 9), (35, 8), (36, 8),\n" +
        "(37, 8), (39, 5), (39, 6), (39, 7), (40, 6), (42, 1), (42, 2), (43, 1),\n" +
        "(44, 0)"
    );

    public final static Set<Cell> CATERLOOPILLAR = fromString(
        "(0, 10), (0, 11), (0, 12), (0, 13), (0, 16), (0, 17), (0, 18), (0, 19),\n" +
            "(1, 10), (1, 12), (1, 16), (1, 19), (2, 10), (2, 12), (2, 14), (2, 18),\n" +
            "(2, 19), (2, 20), (3, 13), (3, 14), (3, 16), (3, 17), (4, 11), (4, 12),\n" +
            "(4, 13), (4, 17), (5, 11), (5, 12), (5, 14), (5, 15), (6, 11), (6, 12),\n" +
            "(7, 11), (7, 12)"
    );

    public final static Set<Cell> ACHIMS_P11 = fromString(
        "(0, 0), (0, 4), (0, 6), (0, 10),\n" +
        "(1, 1), (1, 2), (1, 3), (1, 7), (1, 8), (1, 9),\n" +
        "(3, 0), (3, 4), (3, 6), (3, 10),\n" +
        "(4, 0), (4, 1), (4, 2), (4, 3), (4, 7), (4, 8), (4, 9),\n" +
        "(5, 5), (5, 6)"
    );
    public final static Set<Cell> FERMAT_BEEHIVE_BUFFER = fromString(
        "(1, 26), (1, 28), (2, 24), (2, 28), (3, 20), (3, 24), " +
        "(3, 25), (3, 27), (3, 28), (4, 14), (4, 15), (4, 16), " +
        "(4, 17), (4, 18), (4, 20), (4, 21), (4, 23), (4, 24), " +
        "(4, 26), (4, 28), (5, 14), (5, 17), (5, 19), (5, 21), " +
        "(5, 23), (5, 25), (5, 27), (5, 28), (5, 30), (6, 13), " +
        "(6, 14), (6, 15), (6, 16), (6, 17), (6, 18), (6, 19), " +
        "(6, 20), (6, 21), (6, 23), (6, 24), (6, 26), (6, 28), " +
        "(6, 30), (6, 31), (6, 32), (7, 12), (7, 20), (7, 23), " +
        "(7, 25), (7, 26), (7, 28), (7, 29), (7, 30), (7, 31), " +
        "(8, 5), (8, 6), (8, 9), (8, 11), (8, 12), (8, 15), (8, 17), " +
        "(8, 18), (8, 19), (8, 23), (8, 24), (8, 25), (8, 26), (8, 27), " +
        "(8, 30), (8, 32), (8, 33), (8, 34), (9, 4), (9, 12), (9, 16), " +
        "(9, 18), (9, 26), (9, 30), (9, 32), (9, 34), (10, 5), (10, 12), " +
        "(10, 15), (10, 17), (10, 18), (10, 19), (10, 23), (10, 24), " +
        "(10, 25), (10, 26), (10, 27), (10, 30), (10, 31), (10, 32), " +
        "(11, 13), (11, 14), (11, 15), (11, 16), (11, 17), (11, 18), " +
        "(11, 19), (11, 20), (11, 21), (11, 23), (11, 24), (11, 26), " +
        "(11, 28), (11, 30), (11, 31), (11, 32), (12, 14), (12, 17), " +
        "(12, 19), (12, 21), (12, 23), (12, 25), (12, 27), (12, 28), " +
        "(12, 30), (13, 20), (13, 24), (14, 24), (14, 25), (14, 27), " +
        "(14, 28), (15, 26), (16, 24), (16, 28), (17, 26), (18, 26), " +
        "(19, 27), (19, 28), (20, 26), (20, 28), (21, 27), (21, 28), " +
        "(22, 26), (22, 28), (23, 27), (23, 28), (24, 26), (24, 28), " +
        "(25, 27), (25, 28), (26, 24), (26, 28), (27, 20), (27, 24)"
    );

    public final static Set<Cell> FERMAT_PRIMER = fromConwaysNotation(
            "275bo14bo$274b3o12b3o$274bob2o10b2obo$275b3o10b3o$275b3o10b3o$275b2o3b\n" +
            "6o3b2o$279b3o2b3o$279bob4obo$281bo2bo$277b2o3b2o3b2o$279bo6bo$279bo6bo\n" +
            "$278b2o2b2o2b2o$278b2obo2bob2o154b3o15b3o$278b2o2b2o2b2o153bo3bo13bo3b\n" +
            "o$279bo2b2o2bo153b2o4bo11bo4b2o$281bo2bo154bobob2ob2o3b3o3b2ob2obobo$\n" +
            "278bo2bo2bo2bo150b2obo4bob2ob3ob2obo4bob2o$279bobo2bobo145bo4bo4bo3bo\n" +
            "4bobo4bo3bo4bo$428b2ob3o15bo5bo$280b6o140b2obo3b2o2b2o7b2o9b2o7b2o$\n" +
            "280b2o2b2o136b5o4bo2b2o$279bo6bo131b2ob2obobobo5bo2bo$279b8o129b2obo3b\n" +
            "o3bo8bo$277b2obo4bob2o123b5o4bo$276bo12bo118b2ob2obobobo3bo$276bo3b6o\n" +
            "3bo116b2obo3bo3bo$275bo3b2o4b2o3bo111b5o4bo$274bo5bo4bo5bo106b2ob2obob\n" +
            "obo3bo$275bo3b2o4b2o3bo105b2obo3bo3bo$275bo5bo2bo5bo101b5o4bo$276b2obo\n" +
            "bo2bobob2o98b2ob2obobobo3bo$278b2obo2bob2o98b2obo3bo3bo$276b4ob4ob4o\n" +
            "92b5o4bo$276bobob2o2b2obobo88b2ob2obobobo3bo$279bo6bo89b2obo3bo3bo$\n" +
            "279bo6bo85b5o4bo$271b3o5bo2b2o2bo81b2ob2obobobo3bo$270bo2bo8b2o82b2obo\n" +
            "3bo3bo$273bo3b3o2b2o2b3o73b5o4bo$268bo4bo3b3ob4ob3o69b2ob2obobobo3bo$\n" +
            "267b3o3bo5b8o69b2obo3bo3bo$266b2obo5bo4b6o66b5o4bo$266b3o7bo71b2ob2obo\n" +
            "bobo3bo$267b2o3b2obo6b2o8b3o15b3o33b2obo3bo3bo$274bo6bo2bo6bo3bo13bo3b\n" +
            "o28b5o4bo$276bo5b2o6b2o4bo11bo4b2o23b2ob2obobobo3bo$275b2o12bobob2ob2o\n" +
            "3b3o3b2ob2obobo20b2obo3bo3bo$274bobo5b2o4b2obo4bob2ob3ob2obo4bob2o15b\n" +
            "5o4bo$273b3o5bo2bo2bo4bo3bo4bobo4bo3bo4bo4bo5b2ob2obobobo3bo$273b3o6b\n" +
            "2o15bo5bo15b3o2b2obo3bo3bo$273b3o11b2o7b2o9b2o7b2o2b3ob3o4bo$273b3o6b\n" +
            "2o35b2o5bobo3bo$274b2o5bo2bo32bo2bo6bo$282b2o34bo2$282b2o47bo13bo$281b\n" +
            "o2bo45b3o11b3o$282b2o46bob2o4bo5bob2o14bo13bo$331b3o3b3o5b3o13b3o11b3o\n" +
            "$282b2o47b2o3b2o2bo4b2o13b2obo5bo4b2obo$281bo2bo53b3o19b3o5b3o3b3o$\n" +
            "282b2o77b2o4bo2b2o3b2o$367b3o$282b2o$281bo2bo59b3o$282b2o59bo2bo$346bo\n" +
            "14b3o$282b2o62bo14bo2bo$281bo2bo58bobo15bo$282b2o51b2o24bo$335b2o25bob\n" +
            "o$282b2o87b2o$281bo2bo44bo41b2o$282b2o44b3o7bo$327b2obo5b2ob2o37bo$\n" +
            "282b2o43b3o6b2ob2o28bo7b3o$281bo2bo43b2o6b2ob2o26b2ob2o5bob2o$282b2o\n" +
            "54b2o4bo5bo16b2ob2o6b3o$343b3o3b3o15b2ob2o6b2o$282b2o58b2obo3bob2o4bo\n" +
            "5bo4b2o$281bo2bo57b3o5b3o3b3o3b3o$282b2o59b2o5b2o3b2obo3bob2o$355b3o5b\n" +
            "3o$282b2o52b2o9bo8b2o5b2o$281bo2bo52b2o7b3o$282b2o52bo8bo3bo10bo9b2o$\n" +
            "359b3o7b2o$282b2o28b3o11b3o29bo3bo8bo$281bo2bo26bo2bo10bo2bo12b2o2b2ob\n" +
            "2o$282b2o30bo4b3o6bo13b2o3bo31b3o11b3o$314bo4bo2bo5bo12bo16b2ob2o2b2o\n" +
            "12bo2bo10bo2bo$282b2o27bobo4bo3bo2bobo32bo3b2o13bo6b3o4bo$281bo2bo33bo\n" +
            "bob2o21bo3bo16bo12bo5bo2bo4bo$282b2o35b2ob2o20bobobobo29bobo2bo3bo4bob\n" +
            "o$320b3o22b5o8bo3bo21b2obobo$282b2o29bo31b2ob2o7bobobobo20b2ob2o$281bo\n" +
            "2bo27b3o31bobo9b5o22b3o$282b2o27b2obo6bo24b3o9b2ob2o31bo$311b3o6b2o37b\n" +
            "obo31b3o$282b2o28b2o7bo37b3o24bo6bob2o$281bo2bo33bo27bo39b2o6b3o$282b\n" +
            "2o32b4obo18bo4bobo38bo7b2o$317bo2bo18b3o3bo2bo12bo27bo$282b2o34b3o18bo\n" +
            "b2o3b2o12bobo4bo18bob4o$281bo2bo55b3o16bo2bo3b3o18bo2bo$282b2o44b3o9b\n" +
            "3o17b2o3b2obo18b3o$293bo13bo19bo2bo9b2o6bo16b3o$282b2o8b3o11b3o21bo17b\n" +
            "o16b3o9b3o$281bo2bo6b2obo5bo4b2obo21bo17bo10bo6b2o9bo2bo$282b2o7b3o5b\n" +
            "3o3b3o19bobo29bo17bo$292b2o5bob2o3b2o51bo17bo$282b2o94bobo18b3o11b3o$\n" +
            "281bo2bo40bo7b3o3b3o56bo2bo10bo2bo$282b2o42b2o5bo2bobo2bo59bo4b3o6bo$\n" +
            "302bo22b2o6bo7bo24b3o3b3o7bo18bo4bo2bo5bo$282b2o16b2o4b3o24bo7bo24bo2b\n" +
            "obo2bo5b2o16bobo4bo3bo2bobo$281bo2bo21bo2bo24bobobobo25bo7bo6b2o22bobo\n" +
            "b2o$282b2o19bo2bo59bo7bo31b2ob2o$298bo7bo30bo29bobobobo33b3o$282b2o13b\n" +
            "o3b2o4bobo26b3o61bo$281bo2bo12bo38b3o31bo28b3o$282b2o14bo70b3o26b2obo\n" +
            "6bo$308b3o3b3o52b3o26b3o6b2o$282b2o7bo9bo5bo2bo3bo2bo81b2o7bo$281bo2bo\n" +
            "5b3o6b3o8bo3bo20bo3bo65bo$282b2o6bob2o5bo10bo3bo20bo3bo63b4obo$291b3o\n" +
            "5bobo5bobo5bobo16bobobobo27bo3bo19bo5bo5bo2bo$282b2o7b2o7b2o28bo5b3o\n" +
            "29bo3bo18b3o3b3o5b3o$281bo2bo26b3o17b2o3b3o28bobobobo16b2obo3bob2o14b\n" +
            "3o$282b2o27b3o16b2o5bo9b2o20b3o5bo12b3o5b3o14bo2bo$310bobobo32bobo19b\n" +
            "3o3b2o14b2o5b2o15bo$282b2o64b2o9b2o9bo5b2o37bo$281bo2bo73bobo34bo20bob\n" +
            "o$282b2o14bo37b2o20b2o34b3o$298b2o9b2o3b2o4bo14bo2bo54bo3bo$282b2o13bo\n" +
            "bo10b2ob2o4b3o13bo34b2o$281bo2bo25b2ob2o4bob2o5b4o4b2o9b2o20bo2bo14bo$\n" +
            "282b2o28bo7b3o4b2ob3o13bo2bo22bo13b3o4b2ob2o11b3o$303bo16b2o4b2o2bo2bo\n" +
            "13b2o10b2o9b2o4b4o5b2obo6bo13bo$282b2o19b2o22bo3b3obo22bo2bo13b3ob2o4b\n" +
            "3o22bo$281bo2bo17bobo23bo2b2ob2o23b2o13bo2bo2b2o4b2o$282b2o48bob2o36bo\n" +
            "b3o3bo12bo3bo$332b2o38b2ob2o2bo12bobobobo5b3o$282b2o24bo63b2obo17b5o6b\n" +
            "o$281bo2bo23b2o64b2o17b2ob2o7bo$282b2o23bobo84bobo$394b3o$282b2o21bo\n" +
            "93b3o$281bo2bo19b3o92bo$282b2o20bob2o92bo$305b3o$282b2o21b3o$281bo2bo\n" +
            "20b2o95bo$282b2o34bo82b3o$318b2o80b2obo$282b2o33bobo80b3o$281bo2bo115b\n" +
            "3o$282b2o55bo49b3o8b3o$336b2o3bo47bo11b2o$282b2o52bo4bo5b2o19bo21bo$\n" +
            "281bo2bo52bo9bobo16bo3b2o$282b2o64b2o9b2o5bo4bo$358bobo9bo$282b2o74b2o\n" +
            "$281bo2bo$282b2o2$282b2o$281bo2bo48bo$282b2o49b2o$332bobo$282b2o$281bo\n" +
            "2bo89b3o$282b2o90bo$375bo41b3o11b3o$282b2o133bo2bo10bo2bo$281bo2bo96bo\n" +
            "13bo21bo6b3o4bo$282b2o96b3o11b3o20bo5bo2bo4bo$379b2obo5bo4b2obo21bobo\n" +
            "6bo4bobo$282b2o95b3o5b3o3b3o26bo$281bo2bo95b2o4bo2b2o3b2o27bo4bo$282b\n" +
            "2o102b2ob2o37bo$385b3o2bo27bo7bo$282b2o102b2obo27b3o5b2o$281bo2bo102bo\n" +
            "29bob2o2b3o$282b2o103bo3bo2b3o21b3o3bo$345b2o41bobo3bo2bo20b2o$282b2o\n" +
            "61b2o42bo4bo$281bo2bo51b2o3bo6b2o12b2o30bo$282b2o52bobo3bo5b3o10bo3bo\n" +
            "29bobo12bo5bo$337b5o6b2o10bo5bo3b2o37b3o3b3o$282b2o54b3o4b2o13bo3bob2o\n" +
            "2b2o37bob2ob2obo15b3o$281bo2bo60b2o8bo4bo5bo29b3o3b3o5b3ob3o15bo2bo$\n" +
            "282b2o71bo5bo3bo13bo15bo2bo3bo2bo4b2o3b2o18bo$362b2o14b3o4b2o11bo3bo\n" +
            "32bo$282b2o94bob2o16bo3bo10bo18bobo$281bo2bo94b3o13bobo5bobo6bobo13bob\n" +
            "o$282b2o95b2o30bo3bo11bo2bo$384b2o13b3o10bobo15bo$282b2o99b3o13b3o11bo\n" +
            "13b2o19b3o11b3o$281bo2bo99bo2bo11b3o11bo34bo2bo10bo2bo$282b2o101b2o25b\n" +
            "obo33bo6b3o4bo$412bobo33bo5bo2bo4bo$282b2o115b3o11bo10b2o23bobo2bo3bo\n" +
            "4bobo$281bo2bo114b3o22bobo26b2obobo$282b2o104bo35bo28b2ob2o$388b2o20b\n" +
            "2o3b2o37b3o$282b2o103bobo8bo3bo46bo$281bo2bo79b2o31bo5bo15b2o27b3o$\n" +
            "282b2o81b2o30bo5bo15bobo26bob2o$364bo28bo19bo5bo29b3o$282b2o109b2o18bo\n" +
            "35b2o$281bo2bo107bobo4bobo$282b2o116bo13b2o$414bobo24bo5bo10b2o$282b2o\n" +
            "73bo40bo15bo5bo19b3o3b3o9b2o$281bo2bo60b2o10b2o39b2o19b3o18bob2ob2obo\n" +
            "15b3o$282b2o61b2o9bobo38bobo18b2obo19b3ob3o7b3o5bo2bo$336b2o3bo6b2o12b\n" +
            "2o28b3o23b3o20b2o3b2o6bo3bo7bo$282b2o52bobo3bo5b3o10bo3bo25bo2bo23b3o\n" +
            "33bo4bo6bo$281bo2bo52b5o6b2o10bo5bo3b2o22bo24b2o23bo14bo3bobo$282b2o\n" +
            "54b3o4b2o13bo3bob2o2b2o18bo3bo48bobo8bo4bo$345b2o13bo5bo27bo47bo3bo11b\n" +
            "o$282b2o77bo3bo13b2o10bobo49bobo9bobo$281bo2bo77b2o16b2o62bo$282b2o95b\n" +
            "o28b2o34bo$408bo34bobo$282b2o122bobo34bobo10b2o$281bo2bo121b2o36bo11bo\n" +
            "bo$282b2o172bo$372bo$282b2o88b2o67b2o3b2o$281bo2bo86bobo77b2o$282b2o\n" +
            "167bobo$451bo$282b2o160bo$281bo2bo159bo$282b2o162b2o$364b2o28b2o50bobo\n" +
            "$282b2o81b2o28b2o49bo$281bo2bo79bo29bo56bo$282b2o166b3o$441b2o6b2obo$\n" +
            "282b2o157bobo5b3o$281bo2bo156bo7b3o$282b2o73bo29bo62b2o$345b2o10b2o28b\n" +
            "2o$282b2o61b2o9bobo27bobo$281bo2bo51b2o3bo6b2o12b2o$282b2o52bobo3bo5b\n" +
            "3o10bo3bo$337b5o6b2o10bo5bo3b2o$282b2o54b3o4b2o13bo3bob2o2b2o$281bo2bo\n" +
            "60b2o13bo5bo$282b2o77bo3bo13b2o$362b2o16b2o$282b2o95bo28b2o$281bo2bo\n" +
            "123bo$282b2o122bobo17b2o$406b2o18bobo$282b2o142bo$281bo2bo87bo29bo$\n" +
            "282b2o88b2o28b2o$371bobo27bobo$282b2o$281bo2bo$282b2o2$282b2o$281bo2bo\n" +
            "79b2o28b2o$282b2o81b2o28b2o$364bo29bo$282b2o$281bo2bo126b2o$282b2o127b\n" +
            "obo$411bo$282b2o73bo29bo$281bo2bo60b2o10b2o28b2o$282b2o61b2o9bobo27bob\n" +
            "o$336b2o3bo6b2o12b2o$282b2o52bobo3bo5b3o10bo3bo$281bo2bo52b5o6b2o10bo\n" +
            "5bo3b2o$282b2o54b3o4b2o13bo3bob2o2b2o$345b2o13bo5bo$282b2o77bo3bo13b2o\n" +
            "$281bo2bo77b2o16b2o$282b2o95bo28b2o$408bo$282b2o122bobo$281bo2bo121b2o\n" +
            "$282b2o$372bo29bo$282b2o88b2o28b2o$281bo2bo86bobo27bobo$282b2o2$282b2o\n" +
            "$281bo2bo$282b2o$364b2o28b2o13bo$282b2o81b2o28b2o10bobo$281bo2bo79bo\n" +
            "29bo13b2o$282b2o2$282b2o$281bo2bo$282b2o73bo29bo$345b2o10b2o28b2o$282b\n" +
            "2o61b2o9bobo27bobo$281bo2bo51b2o3bo6b2o12b2o$282b2o52bobo3bo5b3o10bo3b\n" +
            "o$337b5o6b2o10bo5bo3b2o$282b2o54b3o4b2o13bo3bob2o2b2o$281bo2bo60b2o13b\n" +
            "o5bo$282b2o77bo3bo13b2o$362b2o16b2o$282b2o95bo28b2o$281bo2bo123bo$282b\n" +
            "2o122bobo$406b2o$282b2o$281bo2bo87bo29bo$282b2o88b2o28b2o$371bobo27bob\n" +
            "o$282b2o$281bo2bo$282b2o2$282b2o$281bo2bo79b2o28b2o$282b2o81b2o28b2o$\n" +
            "364bo29bo$282b2o$281bo2bo$282b2o2$282b2o73bo29bo$281bo2bo60b2o10b2o28b\n" +
            "2o$282b2o61b2o9bobo27bobo$336b2o3bo6b2o12b2o$282b2o52bobo3bo5b3o10bo3b\n" +
            "o$281bo2bo52b5o6b2o10bo5bo3b2o$282b2o54b3o4b2o13bo3bob2o2b2o$345b2o13b\n" +
            "o5bo$282b2o77bo3bo13b2o43bo$281bo2bo77b2o16b2o40bobo$282b2o95bo28b2o\n" +
            "13b2o$408bo$282b2o122bobo$281bo2bo121b2o$282b2o$372bo29bo$282b2o88b2o\n" +
            "28b2o$281bo2bo86bobo27bobo$282b2o2$282b2o$281bo2bo$282b2o$364b2o28b2o$\n" +
            "282b2o81b2o28b2o$281bo2bo79bo29bo$282b2o2$282b2o$281bo2bo$282b2o73bo\n" +
            "29bo$345b2o10b2o28b2o$282b2o61b2o9bobo27bobo$281bo2bo51b2o3bo6b2o12b2o\n" +
            "$282b2o52bobo3bo5b3o10bo3bo$337b5o6b2o10bo5bo3b2o$282b2o54b3o4b2o13bo\n" +
            "3bob2o2b2o$281bo2bo60b2o13bo5bo$282b2o77bo3bo13b2o$362b2o16b2o$282b2o\n" +
            "95bo28b2o$281bo2bo123bo$282b2o122bobo$406b2o$282b2o$281bo2bo87bo29bo$\n" +
            "282b2o88b2o28b2o$371bobo27bobo$282b2o$281bo2bo$282b2o2$282b2o$281bo2bo\n" +
            "79b2o28b2o43bo$282b2o81b2o28b2o40bobo$364bo29bo43b2o$282b2o$281bo2bo$\n" +
            "282b2o2$282b2o73bo29bo$281bo2bo60b2o10b2o28b2o$282b2o61b2o9bobo27bobo$\n" +
            "336b2o3bo6b2o12b2o$282b2o52bobo3bo5b3o10bo3bo$281bo2bo52b5o6b2o10bo5bo\n" +
            "3b2o$282b2o54b3o4b2o13bo3bob2o2b2o$345b2o13bo5bo$282b2o77bo3bo13b2o$\n" +
            "281bo2bo77b2o16b2o$282b2o95bo28b2o$408bo$282b2o122bobo$281bo2bo121b2o$\n" +
            "282b2o$372bo29bo$282b2o88b2o28b2o$281bo2bo86bobo27bobo$282b2o2$282b2o$\n" +
            "281bo2bo$282b2o$364b2o28b2o$282b2o81b2o28b2o$281bo2bo79bo29bo$282b2o2$\n" +
            "282b2o$281bo2bo$282b2o73bo29bo$345b2o10b2o28b2o$282b2o61b2o9bobo27bobo\n" +
            "$281bo2bo51b2o3bo6b2o12b2o$282b2o52bobo3bo5b3o10bo3bo$337b5o6b2o10bo5b\n" +
            "o3b2o$282b2o54b3o4b2o13bo3bob2o2b2o$281bo2bo60b2o13bo5bo$282b2o77bo3bo\n" +
            "13b2o73bo$362b2o16b2o70bobo$282b2o95bo28b2o43b2o$281bo2bo123bo$282b2o\n" +
            "122bobo$406b2o$282b2o$281bo2bo87bo29bo$282b2o88b2o28b2o$371bobo27bobo$\n" +
            "282b2o$281bo2bo$282b2o2$282b2o$281bo2bo79b2o28b2o$282b2o81b2o28b2o$\n" +
            "364bo29bo$282b2o$281bo2bo$282b2o2$282b2o73bo29bo$281bo2bo60b2o10b2o28b\n" +
            "2o$282b2o61b2o9bobo27bobo$336b2o3bo6b2o12b2o$282b2o52bobo3bo5b3o10bo3b\n" +
            "o$281bo2bo52b5o6b2o10bo5bo3b2o$282b2o54b3o4b2o13bo3bob2o2b2o$345b2o13b\n" +
            "o5bo$282b2o77bo3bo13b2o$281bo2bo77b2o16b2o$282b2o95bo28b2o$408bo$282b\n" +
            "2o122bobo$281bo2bo121b2o$282b2o$372bo29bo$282b2o88b2o28b2o$281bo2bo86b\n" +
            "obo27bobo$282b2o2$282b2o$281bo2bo$282b2o$364b2o28b2o73bo$282b2o81b2o\n" +
            "28b2o70bobo$281bo2bo79bo29bo73b2o$282b2o2$282b2o$281bo2bo$282b2o73bo\n" +
            "29bo$345b2o10b2o28b2o$282b2o61b2o9bobo27bobo$281bo2bo51b2o3bo6b2o12b2o\n" +
            "$282b2o52bobo3bo5b3o10bo3bo$337b5o6b2o10bo5bo3b2o$282b2o54b3o4b2o13bo\n" +
            "3bob2o2b2o$281bo2bo60b2o13bo5bo$282b2o77bo3bo13b2o$362b2o16b2o$282b2o\n" +
            "95bo28b2o$281bo2bo123bo$282b2o122bobo$406b2o$282b2o$281bo2bo87bo29bo$\n" +
            "282b2o88b2o28b2o$371bobo27bobo$282b2o$281bo2bo$282b2o2$282b2o$281bo2bo\n" +
            "79b2o28b2o$282b2o81b2o28b2o$364bo29bo$282b2o$281bo2bo$282b2o2$282b2o\n" +
            "73bo29bo$281bo2bo60b2o10b2o28b2o$282b2o61b2o9bobo27bobo$336b2o3bo6b2o\n" +
            "12b2o$282b2o52bobo3bo5b3o10bo3bo$281bo2bo52b5o6b2o10bo5bo3b2o$282b2o\n" +
            "54b3o4b2o13bo3bob2o2b2o$345b2o13bo5bo$282b2o77bo3bo13b2o103bo$281bo2bo\n" +
            "77b2o16b2o100bobo$282b2o95bo28b2o73b2o$408bo$282b2o122bobo$281bo2bo\n" +
            "121b2o$282b2o$372bo29bo$282b2o88b2o28b2o$281bo2bo86bobo27bobo$282b2o2$\n" +
            "282b2o$281bo2bo$282b2o$364b2o28b2o$282b2o81b2o28b2o$281bo2bo79bo29bo$\n" +
            "282b2o2$282b2o$281bo2bo$282b2o73bo29bo$345b2o10b2o28b2o$282b2o61b2o9bo\n" +
            "bo27bobo$281bo2bo51b2o3bo6b2o12b2o$282b2o52bobo3bo5b3o10bo3bo$337b5o6b\n" +
            "2o10bo5bo3b2o$282b2o54b3o4b2o13bo3bob2o2b2o$281bo2bo60b2o13bo5bo$282b\n" +
            "2o77bo3bo13b2o$362b2o16b2o$282b2o95bo28b2o$281bo2bo123bo$282b2o122bobo\n" +
            "$406b2o$282b2o$281bo2bo87bo29bo$282b2o88b2o28b2o$371bobo27bobo$282b2o$\n" +
            "281bo2bo$282b2o2$282b2o$281bo2bo79b2o28b2o103bo$282b2o81b2o28b2o100bob\n" +
            "o$364bo29bo103b2o$282b2o$281bo2bo$282b2o2$282b2o73bo29bo$281bo2bo60b2o\n" +
            "10b2o28b2o$282b2o61b2o9bobo27bobo$336b2o3bo6b2o12b2o$282b2o52bobo3bo5b\n" +
            "3o10bo3bo$281bo2bo52b5o6b2o10bo5bo3b2o$282b2o54b3o4b2o13bo3bob2o2b2o$\n" +
            "345b2o13bo5bo$282b2o77bo3bo13b2o$281bo2bo77b2o16b2o$282b2o95bo28b2o$\n" +
            "408bo$282b2o122bobo$281bo2bo121b2o$282b2o$372bo29bo$282b2o88b2o28b2o$\n" +
            "281bo2bo86bobo27bobo$282b2o2$282b2o$281bo2bo$282b2o$364b2o28b2o$282b2o\n" +
            "81b2o28b2o$281bo2bo79bo29bo$282b2o2$282b2o$281bo2bo$282b2o73bo29bo$\n" +
            "345b2o10b2o28b2o$282b2o61b2o9bobo27bobo$281bo2bo51b2o3bo6b2o12b2o$282b\n" +
            "2o52bobo3bo5b3o10bo3bo$337b5o6b2o10bo5bo3b2o$282b2o54b3o4b2o13bo3bob2o\n" +
            "2b2o$281bo2bo60b2o13bo5bo$282b2o77bo3bo13b2o133bo$362b2o16b2o130bobo$\n" +
            "282b2o95bo28b2o103b2o$281bo2bo123bo$282b2o122bobo$406b2o$282b2o$281bo\n" +
            "2bo87bo29bo$282b2o88b2o28b2o$371bobo27bobo$282b2o$281bo2bo$282b2o2$\n" +
            "282b2o$281bo2bo79b2o28b2o$282b2o81b2o28b2o$364bo29bo$282b2o$281bo2bo$\n" +
            "282b2o2$282b2o73bo29bo$281bo2bo60b2o10b2o28b2o$282b2o61b2o9bobo27bobo$\n" +
            "336b2o3bo6b2o12b2o$282b2o52bobo3bo5b3o10bo3bo$281bo2bo52b5o6b2o10bo5bo\n" +
            "3b2o$282b2o54b3o4b2o13bo3bob2o2b2o$345b2o13bo5bo$282b2o77bo3bo13b2o$\n" +
            "281bo2bo77b2o16b2o$282b2o95bo28b2o$408bo$282b2o122bobo$281bo2bo121b2o$\n" +
            "282b2o$372bo29bo$282b2o88b2o28b2o$281bo2bo86bobo27bobo$282b2o2$282b2o$\n" +
            "281bo2bo$282b2o$364b2o28b2o133bo$282b2o81b2o28b2o130bobo$281bo2bo79bo\n" +
            "29bo133b2o$282b2o2$282b2o$281bo2bo$282b2o73bo29bo$345b2o10b2o28b2o$\n" +
            "282b2o61b2o9bobo27bobo$281bo2bo51b2o3bo6b2o12b2o$282b2o52bobo3bo5b3o\n" +
            "10bo3bo$337b5o6b2o10bo5bo3b2o$282b2o54b3o4b2o13bo3bob2o2b2o$281bo2bo\n" +
            "60b2o13bo5bo$282b2o77bo3bo13b2o$362b2o16b2o$282b2o95bo28b2o$281bo2bo\n" +
            "123bo$282b2o122bobo$406b2o$282b2o$281bo2bo87bo29bo$282b2o88b2o28b2o$\n" +
            "371bobo27bobo$282b2o$281bo2bo$282b2o2$282b2o$281bo2bo79b2o28b2o$282b2o\n" +
            "81b2o28b2o$364bo29bo$282b2o$281bo2bo$282b2o2$282b2o73bo29bo$281bo2bo\n" +
            "60b2o10b2o28b2o$282b2o61b2o9bobo27bobo$336b2o3bo6b2o12b2o$282b2o52bobo\n" +
            "3bo5b3o10bo3bo$281bo2bo52b5o6b2o10bo5bo3b2o$282b2o54b3o4b2o13bo3bob2o\n" +
            "2b2o$345b2o13bo5bo$282b2o77bo3bo13b2o163bo$281bo2bo77b2o16b2o160bobo$\n" +
            "282b2o95bo28b2o133b2o$408bo$282b2o122bobo$281bo2bo121b2o$282b2o$372bo\n" +
            "29bo$282b2o88b2o28b2o$281bo2bo86bobo27bobo$282b2o2$282b2o$281bo2bo$\n" +
            "282b2o$364b2o28b2o$282b2o81b2o28b2o$281bo2bo79bo29bo$282b2o2$282b2o$\n" +
            "281bo2bo$282b2o73bo29bo$345b2o10b2o28b2o$282b2o61b2o9bobo27bobo$281bo\n" +
            "2bo51b2o3bo6b2o12b2o$282b2o52bobo3bo5b3o10bo3bo$337b5o6b2o10bo5bo3b2o$\n" +
            "282b2o54b3o4b2o13bo3bob2o2b2o$281bo2bo60b2o13bo5bo$282b2o77bo3bo13b2o$\n" +
            "362b2o16b2o$282b2o95bo28b2o$281bo2bo123bo$282b2o122bobo$406b2o$282b2o$\n" +
            "281bo2bo87bo29bo$282b2o88b2o28b2o$371bobo27bobo$282b2o$281bo2bo$282b2o\n" +
            "2$282b2o$281bo2bo79b2o28b2o163bo$282b2o81b2o28b2o160bobo$364bo29bo163b\n" +
            "2o$282b2o$281bo2bo$282b2o2$282b2o73bo29bo$281bo2bo60b2o10b2o28b2o$282b\n" +
            "2o61b2o9bobo27bobo$336b2o3bo6b2o12b2o$282b2o52bobo3bo5b3o10bo3bo$281bo\n" +
            "2bo52b5o6b2o10bo5bo3b2o$282b2o54b3o4b2o13bo3bob2o2b2o$345b2o13bo5bo$\n" +
            "282b2o77bo3bo13b2o$281bo2bo77b2o16b2o$282b2o95bo28b2o$408bo$282b2o122b\n" +
            "obo$281bo2bo121b2o$282b2o$372bo29bo$282b2o88b2o28b2o$281bo2bo86bobo27b\n" +
            "obo$282b2o2$282b2o$281bo2bo$282b2o$364b2o28b2o$282b2o81b2o28b2o$281bo\n" +
            "2bo79bo29bo$282b2o2$282b2o$281bo2bo$282b2o73bo29bo$345b2o10b2o28b2o$\n" +
            "282b2o61b2o9bobo27bobo$281bo2bo51b2o3bo6b2o12b2o$282b2o52bobo3bo5b3o\n" +
            "10bo3bo$337b5o6b2o10bo5bo3b2o$282b2o54b3o4b2o13bo3bob2o2b2o$281bo2bo\n" +
            "60b2o13bo5bo$282b2o77bo3bo13b2o193bo$362b2o16b2o190bobo$282b2o95bo28b\n" +
            "2o163b2o$281bo2bo123bo$282b2o122bobo$406b2o$282b2o$281bo2bo87bo29bo$\n" +
            "282b2o88b2o28b2o$371bobo27bobo$282b2o$281bo2bo$282b2o2$282b2o$281bo2bo\n" +
            "79b2o28b2o$282b2o81b2o28b2o$364bo29bo$282b2o$281bo2bo$282b2o2$282b2o\n" +
            "73bo29bo$281bo2bo60b2o10b2o28b2o$282b2o61b2o9bobo27bobo$336b2o3bo6b2o\n" +
            "12b2o$282b2o52bobo3bo5b3o10bo3bo$281bo2bo52b5o6b2o10bo5bo3b2o$282b2o\n" +
            "54b3o4b2o13bo3bob2o2b2o$345b2o13bo5bo$282b2o77bo3bo13b2o$281bo2bo77b2o\n" +
            "16b2o$282b2o95bo28b2o$408bo$282b2o122bobo$281bo2bo121b2o$282b2o$372bo\n" +
            "29bo$282b2o88b2o28b2o$281bo2bo86bobo27bobo$282b2o2$282b2o$281bo2bo$\n" +
            "282b2o$364b2o28b2o193bo$282b2o81b2o28b2o190bobo$281bo2bo79bo29bo193b2o\n" +
            "$282b2o2$282b2o$281bo2bo$282b2o73bo29bo$345b2o10b2o28b2o$282b2o61b2o9b\n" +
            "obo27bobo$281bo2bo51b2o3bo6b2o12b2o$282b2o52bobo3bo5b3o10bo3bo$337b5o\n" +
            "6b2o10bo5bo3b2o$282b2o54b3o4b2o13bo3bob2o2b2o$281bo2bo60b2o13bo5bo$\n" +
            "282b2o77bo3bo13b2o$362b2o16b2o$282b2o95bo28b2o$281bo2bo123bo$282b2o\n" +
            "122bobo$406b2o$282b2o$281bo2bo87bo29bo$282b2o88b2o28b2o$371bobo27bobo$\n" +
            "282b2o$281bo2bo$282b2o2$282b2o$281bo2bo79b2o28b2o$282b2o81b2o28b2o$\n" +
            "364bo29bo$282b2o$281bo2bo$282b2o2$282b2o73bo29bo$281bo2bo60b2o10b2o28b\n" +
            "2o$282b2o61b2o9bobo27bobo$336b2o3bo6b2o12b2o$282b2o52bobo3bo5b3o10bo3b\n" +
            "o$281bo2bo52b5o6b2o10bo5bo3b2o$282b2o54b3o4b2o13bo3bob2o2b2o$345b2o13b\n" +
            "o5bo$282b2o77bo3bo13b2o223bo$281bo2bo77b2o16b2o220bobo$282b2o95bo28b2o\n" +
            "193b2o$408bo$282b2o122bobo$281bo2bo121b2o$282b2o$372bo29bo$282b2o88b2o\n" +
            "28b2o$281bo2bo86bobo27bobo$282b2o2$282b2o$281bo2bo$282b2o$364b2o28b2o$\n" +
            "282b2o81b2o28b2o$281bo2bo79bo29bo$282b2o2$282b2o$281bo2bo$282b2o73bo\n" +
            "29bo$345b2o10b2o28b2o$282b2o61b2o9bobo27bobo$281bo2bo51b2o3bo6b2o12b2o\n" +
            "$282b2o52bobo3bo5b3o10bo3bo$337b5o6b2o10bo5bo3b2o$282b2o54b3o4b2o13bo\n" +
            "3bob2o2b2o$281bo2bo60b2o13bo5bo$282b2o77bo3bo13b2o$362b2o16b2o$282b2o\n" +
            "95bo28b2o$281bo2bo123bo$282b2o122bobo17b2o$406b2o18bobo$282b2o142bo$\n" +
            "281bo2bo87bo29bo$282b2o88b2o28b2o$371bobo27bobo$282b2o$281bo2bo$282b2o\n" +
            "2$282b2o$281bo2bo79b2o28b2o223bo$282b2o81b2o28b2o220bobo1107bobo$364bo\n" +
            "29bo223b2o1107bo2bo$282b2o1446b2o$281bo2bo1447bo$282b2o1446b4o$1729bo\n" +
            "4bo$282b2o73bo29bo1343bo2bo$281bo2bo60b2o10b2o28b2o1293bo2bo45bo2bo$\n" +
            "282b2o61b2o9bobo27bobo1297bo46bo$336b2o3bo6b2o12b2o1318bo3bo40bob4o$\n" +
            "282b2o52bobo3bo5b3o10bo3bo1317b4o13b4o23bo3bo$281bo2bo52b5o6b2o10bo5bo\n" +
            "3b2o1327bo3bo26bo$282b2o54b3o4b2o13bo3bob2o2b2o1331bo24bobo$345b2o13bo\n" +
            "5bo1332bo2bo$282b2o77bo3bo13b2o1296bo51b3o$281bo2bo77b2o16b2o1293bobo\n" +
            "19b2o31b2o$282b2o95bo28b2o1266b2o18b5o28b3o$408bo1280bob3o2bo4bo$282b\n" +
            "2o122bobo1278b2o3bo3b3o2bo26bobo$281bo2bo121b2o1264bo14bobo7bo2b2o28bo\n" +
            "$282b2o1386bobo14bob2o7b2o27bo3bo$372bo29bo1255b3o10b2o15b2o37bob4o$\n" +
            "282b2o88b2o28b2o1253b5o27bo43bo$281bo2bo86bobo27bobo1253b3ob2o68bo2bo$\n" +
            "282b2o1376b2o5bo25b2o5b4o27bo2bo$1665bobo17b2o4b2ob2o3bo3bo25bo4bo$\n" +
            "282b2o1382b2o16b4o3b4o8bo26b4o$281bo2bo1399b2ob2o3b2o5bo2bo29bo$282b2o\n" +
            "1391b3ob2o5b2o42b2o$364b2o28b2o1266bo11b2o5bo45bo2bo$282b2o81b2o28b2o\n" +
            "1263bobo10bo7b2o42bobobo$281bo2bo79bo29bo1266b2o11b2o5bo19b2o5b4o12bo$\n" +
            "282b2o1391b3ob2o5b2o11b2ob2o3bo3bo14bo$501b2o1181b2ob2o10b4o8bo13b3o$\n" +
            "282b2o217bobo1180b4o12b2o5bo2bo16b2o$281bo2bo216bo1183b2o41b2o$282b2o\n" +
            "73bo29bo1307b2o9bo19bobo$345b2o10b2o28b2o1304b5o8b3o$282b2o61b2o9bobo\n" +
            "27bobo1304b2o4bo5bo3bo17b2o$281bo2bo51b2o3bo6b2o12b2o1329b2o5b5o4bo15b\n" +
            "o2bo$282b2o52bobo3bo5b3o10bo3bo1329b2o4b4obob2o14bo2bo$337b5o6b2o10bo\n" +
            "5bo3b2o1326b3ob2o3bo17b3o$282b2o54b3o4b2o13bo3bob2o2b2o1332bobo19bo$\n" +
            "281bo2bo60b2o13bo5bo1358b2o$282b2o77bo3bo13b2o73bo179bo1012bo36bo39bob\n" +
            "o$362b2o16b2o70bobo177bobo1010bobo34b2o24b4o10bo2b2o$282b2o95bo28b2o\n" +
            "43b2o178b2o1011b2o35b2o22bo3bo11bobo$281bo2bo123bo1281b4o17bo$282b2o\n" +
            "122bobo1280bo3bo13bo2bo13b2o$406b2o1261bo23bo28bo2bo$282b2o1383b2o20bo\n" +
            "2bo28bo2bo$281bo2bo87bo29bo1265b2o11bo2bo37b3o$282b2o88b2o28b2o1264b2o\n" +
            "15bo37bo$371bobo27bobo1264b2o11bo3bo36b2o$282b2o1370bo15bo11b4o35bobo$\n" +
            "281bo2bo1367b2o11bo7b2o2b3o39bo2b2o$282b2o1369b2o9bo8b2o2b3o40bobo$\n" +
            "1665bo7b2o2b3o$282b2o1386bo11b4o35b2o$281bo2bo79b2o28b2o1236bo35b2o11b\n" +
            "o3bo33bo2bo$282b2o81b2o28b2o1233bobo52bo32bo2bo$364bo29bo1236b2o48bo2b\n" +
            "o34b3o$282b2o1436bo$281bo2bo1386b2o46b2o$282b2o1385b2ob2o44bobo$1669b\n" +
            "4o43bo2b2o$282b2o73bo29bo1259b2o5b4o12b2o45bobo$281bo2bo60b2o10b2o28b\n" +
            "2o1256b2ob2o3bo3bo$282b2o61b2o9bobo27bobo1256b4o8bo60b2o$336b2o3bo6b2o\n" +
            "12b2o1245bo36b2o5bo2bo59bo2bo$282b2o52bobo3bo5b3o10bo3bo1241b2o106bo2b\n" +
            "o$281bo2bo52b5o6b2o10bo5bo3b2o1236b2o31b2o9bo63b3o$282b2o54b3o4b2o13bo\n" +
            "3bob2o2b2o1267b5o8b3o62bo$345b2o13bo5bo1272b2o4bo5bo3bo60b2o$282b2o77b\n" +
            "o3bo13b2o1236bo21b2o5b5o4bo59bobo$281bo2bo77b2o16b2o1233bobo23b2o4b4ob\n" +
            "ob2o57bo2b2o$282b2o95bo28b2o1206b2o26b3ob2o3bo60bobo$408bo1241bobo$\n" +
            "282b2o122bobo167b2o1137b2o$281bo2bo121b2o168bobo1051bo82bo2bo$282b2o\n" +
            "292bo1051b2o24b4o54bo2bo$372bo29bo1226b2o22bo3bo17b2o5b4o27b3o$282b2o\n" +
            "88b2o28b2o1232b4o17bo15b2ob2o3bo3bo28bo$281bo2bo86bobo27bobo1231bo3bo\n" +
            "13bo2bo16b4o8bo27b2o$282b2o1280bo50bo23bo34b2o5bo2bo27bobo$1562b2o49b\n" +
            "2o20bo2bo71bo2b2o$282b2o1279b2o49b2o11bo2bo41bo38bobo$281bo2bo1346bo\n" +
            "39b2o8b2o$282b2o1335bo7bo3bo38bo9bo2bo28b2o$364b2o28b2o13bo239bo952bo\n" +
            "14b3o3bo4b4o39b5o4bo2bo26bo2bo$282b2o81b2o28b2o10bobo237bobo950bobo14b\n" +
            "2o5b2o46b4o3b2ob2o25bo2bo$281bo2bo79bo29bo13b2o238b2o951b2o13bo6b3o49b\n" +
            "o4b2o28b3o$282b2o1333b2o5b2o85bo$1617b3o3bo4b4o26bobo49b2o$282b2o1335b\n" +
            "o7bo3bo27b3o47bobo$281bo2bo1346bo27b3o20b4o21bo2b2o$282b2o73bo29bo\n" +
            "1239bo2bo50bo3bo22bobo$345b2o10b2o28b2o1275b4o17bo$282b2o61b2o9bobo27b\n" +
            "obo1228b2o27bo16bo3bo13bo2bo24b2o$281bo2bo51b2o3bo6b2o12b2o1155bo50bo\n" +
            "44b2ob2o24b2o21bo39bo2bo$282b2o52bobo3bo5b3o10bo3bo1151b2o49b2o45b4o\n" +
            "26b2o16bo2bo39bo2bo$337b5o6b2o10bo5bo3b2o1146b2o49b2o45b2o37bo2bo48b3o\n" +
            "$282b2o54b3o4b2o13bo3bob2o2b2o1287bo48bo$281bo2bo60b2o13bo5bo1273b2o5b\n" +
            "o7bo3bo47b2o$282b2o77bo3bo13b2o73bo1132bo48bo3b2o3b3o3bo4b4o46bobo$\n" +
            "362b2o16b2o70bobo1130bobo47bo9b2o5b2o50bo2b2o$282b2o95bo73b2o1131b2o\n" +
            "48bo7bo6b3o51bobo$281bo2bo1360b2o5b2o$282b2o164bo29bo7b2o20bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo87bo23b2o\n" +
            "3b3o3bo4b4o8b2o36b2o$448b3o27b3o5bobo19b3o27b3o27b3o27b3o27b3o27b3o27b\n" +
            "3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b\n" +
            "3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b\n" +
            "3o83b2o23bo2bo4bo7bo3bo6bo4bo32bo2bo$282b2o167bo29bo4bo24bo29bo29bo29b\n" +
            "o29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo83b2o22bobo17b\n" +
            "o12bo30bo2bo$281bo2bo87bo77b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "91b4o13b2o13bo2bo7bo5bo31b3o$282b2o88b2o1248b6o39b6o32bo$371bobo1248b\n" +
            "4ob2o16b2o57b2o$282b2o1190bo151b2o15b2ob2o55bobo$281bo2bo1187b2o169b4o\n" +
            "29b4o21bo2b2o$282b2o1189b2o169b2o29bo3bo22bobo$1664b2o4b2o7bo$282b2o\n" +
            "168b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b\n" +
            "3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b\n" +
            "3o27b3o27b3o27b3o27b3o27b3o27b3o224b4o2bo2bo24b2o$281bo2bo79b2o85bo3bo\n" +
            "25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo\n" +
            "25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo\n" +
            "25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo\n" +
            "25bo3bo25bo3bo25bo3bo27b2o28b2o28b2o28b2o28b2o28b2o4b3o3b3o3b3o3b3o3b\n" +
            "3o3b3o6bo3b2o27bo2bo$282b2o81b2o83bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23b\n" +
            "o5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23b\n" +
            "o5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23b\n" +
            "o5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo26bobo27bo\n" +
            "bo27bobo27bobo5b2o20bobo27bobo43b4o2bo2bo21bo2bo$364bo85bo5bo23bo5bo\n" +
            "23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo\n" +
            "23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo\n" +
            "23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo\n" +
            "23bo5bo23bo5bo27b2o28b2o28b2o28b2o5bo22b2o28b2o38b2o4b2o7bo21b3o$282b\n" +
            "2o169bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29b\n" +
            "o29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "127bo103bo3bo22bo$281bo2bo166bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo\n" +
            "25bo3bo15b2o8bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25b\n" +
            "o3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25b\n" +
            "o3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo123b2o105b\n" +
            "4o21b2o$282b2o168b3o27b3o27b3o27b3o27b3o27b3o27b3o16bobo8b3o27b3o27b3o\n" +
            "27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o\n" +
            "27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o124b2obo82bo2bo41bob\n" +
            "o$453bo29bo29bo29bo29bo29bo29bo17bo11bo29bo29bo29bo29bo29bo29bo29bo29b\n" +
            "o29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo126b2o87bo38bo2b2o$282b2o73bo1297bo3bo7b6o26bobo$281bo2bo60b2o10b\n" +
            "2o1286b2o9b4o6bo5bo$282b2o61b2o9bobo95b3o27b3o27b3o27b3o27b3o27b3o27b\n" +
            "3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b\n" +
            "3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o\n" +
            "150b4o43b2o5b3o18bo27b2o$336b2o3bo6b2o12b2o90b3o27b3o27b3o27b3o27b3o\n" +
            "27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o\n" +
            "27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o\n" +
            "27b3o132bo3bo12bo3bo39b3o6b2ob2o12bo4bo26bo2bo$282b2o52bobo3bo5b3o10bo\n" +
            "3bo87bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo\n" +
            "3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo\n" +
            "3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo\n" +
            "3bo25bo3bo25bo3bo25bo3bo25bo3bo25b2o28b2o22bo5b2o22bo5b2o13bo4b5o4bo7b\n" +
            "o43b2o5b3o14b2o27bo2bo$281bo2bo52b5o6b2o10bo5bo3b2o75bobo27bobo27bobo\n" +
            "27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bo\n" +
            "bo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo\n" +
            "27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo33bobo27bobo20bobo4bob\n" +
            "o20bobo4bobo12bo6b9o2bo2bo35b2o8b2o9b4o38b3o$282b2o54b3o4b2o13bo3bob2o\n" +
            "2b2o75b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o\n" +
            "18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o\n" +
            "3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o\n" +
            "3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o\n" +
            "18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o\n" +
            "3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o3b2o18b2o3b2o\n" +
            "3b2o18b2o3b2o3b2o18b2o3b2o3b2o25b2o28b2o20bobo5b2o20bobo5b2o12bo4b3o3b\n" +
            "3ob2o41b2o17bo3bo2bo2bo33bo$345b2o13bo5bo81bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo88bo29bo21bo3bo3b7o2bo2bo12b2o\n" +
            "5b4o12bo23bo6bo6b2o23b2o$282b2o77bo3bo1214bo6bo4bo7bo9b2ob2o3bo3bo7b3o\n" +
            "22bo2bo3bo3bo4b2ob2o21bobo$281bo2bo77b2o1232bo3bo9b4o8bo6b5o29b4o4b4o\n" +
            "20bo2b2o$282b2o64b2o1123b2o122b4o10b2o5bo2bo7b3ob2o5b2o30b2o22bobo$\n" +
            "348bo1123bobo157b2o7b2o$282b2o62bobo92bo29bo29bo29bo29bo29bo29bo59bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo72bo54b2o33b2o6b5o40bo22bo56b2o$281bo2bo\n" +
            "61b2o91b2o28b2o28b2o28b2o28b2o28b2o28b2o58b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o127b3o31b2ob2o4bo4bo35bo3bo2bo33bobo12b4o23bo\n" +
            "2bo$282b2o156b2o28b2o28b2o28b2o28b2o28b2o28b2o58b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o121bob3obo20b3o5bo3b4o10bo14b3o17b2o7b\n" +
            "o30b3ob2o11bo2b2o21bo2bo$342bo1180b2o2b2o4b2o12bo2b3o3b2obo3b2o6bo3bo\n" +
            "17bo18b2o6bo24b2o4b3ob3o11bo2b2o21b3o$282b2o58b2o111b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o18bo2bo4b2o12bobo6bo3bo12bo18bo20b2o4b2o25b2o4b2ob\n" +
            "2o12bo2bo23bo$281bo2bo56bobo111b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "15b2ob2ob2o17bo2b3o3b2obo3b2o32bobo18bo26bo7b3o3b2o9b2o23b2o$282b2o\n" +
            "1243bo22b3o5bo3b4o31bo2bo14b2o37bo4b2o33bobo$1520bob6o34b2ob2o125bo2b\n" +
            "2o$282b2o148bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo\n" +
            "27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bo\n" +
            "bo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo\n" +
            "123bo24b3o18b2o32b3o92bobo$281bo2bo147b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o123bo4bo\n" +
            "20bo75b4o50b2o$282b2o149bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo124bo2bo22bo56bo2bo13bo3bo32b2o14b2ob2o18b2o$334b2o\n" +
            "1235b2o32bo16bo31b4o13b4o17bo2bo$282b2o51b2o1232b2ob2o27bo3bo12bo2bo\n" +
            "32b2ob2o13b2o17bo2bo$281bo2bo49bo1153b2o68b3o8b4o16b2o11b4o50b2o34b3o$\n" +
            "282b2o1203bobo35bo32bo11b2o15b2ob2o101bo$373bo52bo29bo59bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo132bo28b2o5bo33bo27b4o101b2o$282b2o89b\n" +
            "3o48b2o28b2o58b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o161b4o67b2o101bobo$281bo2bo91bo48b2o28b2o58b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o160b\n" +
            "2ob2o167bo2b2o$282b2o43bo47b2o1131b3ob2o5b2o55b2o112bobo$327b2o1178b2o\n" +
            "5bo55b3o3b2o9bo$282b2o42bobo1177bo7b2o24b4o26b3o14b2o102b2o$281bo2bo\n" +
            "1222b2o5bo24bo3bo25bo3bo12bob2o99bo2bo$282b2o1224b3ob2o5b2o22bo25b4o\n" +
            "13bobo99bo2bo$417bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo\n" +
            "27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bo\n" +
            "bo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo\n" +
            "148b2o17b2ob2o3b2o5bo2bo3bo2bo27b3o13b2o101b3o$282b2o133b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o148bobo17b4o3b4o8bo153bo$281bo2bo92b3o38bo29bo29bo29bo29bo29bo29b\n" +
            "o29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo150bo18b2o4b2ob2o3bo3bo152b2o$282b2o\n" +
            "35b2o43bo11bo3bo1075b2o35b2o31b2o5b4o41bo2bo106bobo$320b2o40bobo10bo5b\n" +
            "o1072b2ob2o13b2o16b3ob2o86bo6b2o95bo2b2o$282b2o35bo43b2o10bo5bo1072b4o\n" +
            "13b4o15b5o8b2o73bo3bo4b2ob2o95bobo$281bo2bo93bo1076b2o14b2ob2o15b3o8bo\n" +
            "bo24b2o48b4o4b4o$282b2o92bo3bo30bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo138bo22b2o29bo15b2o3b3o4bo55b2o98b2o$377b3o29b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o138bo66b2o6b5o4b2o151bo2bo$282b2o94bo31b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o137b2o66b3o4b\n" +
            "ob2o6bo150bo2bo$281bo2bo27bo1135b2o58b2o8bo4b2o9bo151b3o$282b2o16b2o\n" +
            "10b2o1156b2o35bobo13b2o5bo2bo153bo$300b2o9bobo65b3o1082b3o3bobo36bo13b\n" +
            "2o6bo154b2o$282b2o7b2o3bo6b2o12b2o60b3o1061bo17b3o6bob2o211bobo$281bo\n" +
            "2bo6bobo3bo5b3o10bo3bo57bo3bo1061b2o15bo9b2o59bo2bo147bo2b2o$282b2o8b\n" +
            "5o6b2o10bo5bo3b2o45bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bob\n" +
            "o27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27b\n" +
            "obo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo\n" +
            "138b2o16b3o7bo64bo147bobo$293b3o4b2o13bo3bob2o2b2o45b2o3b2o3b2o18b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o228bo3bo$282b2o16b2o13bo5bo51bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo128b2o82b4o13b4o148b2o$281bo2bo31bo3bo\n" +
            "1108b3ob2o3bo33b2o41bo3bo163bo2bo$282b2o33b2o1110b5o5b2o22b4o4b4o44bo\n" +
            "162bo2bo$1430b3o5b2o15bo2bo3bo3bo4b2ob2o39bo2bo164b3o$282b2o1175bo6bo\n" +
            "6b2o209bo$281bo2bo81bo59bo29bo29bo29bo29bo59bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo188bo\n" +
            "3bo2bo2bo217b2o$282b2o80b2o58b2o28b2o28b2o28b2o28b2o58b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o179b2o9b4o222bobo$365b2o58b2o28b2o28b2o28b\n" +
            "2o28b2o58b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o177b2o5b3o29b2o5bo\n" +
            "2bo186bo2b2o$282b2o1156b3o6b2ob2o28b4o8bo186bobo$281bo2bo95b2o1062b2o\n" +
            "5b3o28b2ob2o3bo3bo$282b2o96b2o1063b2o9b4o24b2o5b4o187b2o$1428bo26bo3bo\n" +
            "220bo2bo$282b2o11b2o1132b2o28bo219bo2bo$281bo2bo10bo61bobo27bobo27bobo\n" +
            "27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bo\n" +
            "bo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo\n" +
            "27bobo27bobo27bobo27bobo27bobo168b2o25bo2bo28bobo190b3o$282b2o9bobo61b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o226b2o3bo190bo$293b2o63bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo186b2o29bo8b3obob2o187b2o$282b2o1159b2ob2o37b3o4bo\n" +
            "186bobo$281bo2bo1158b4o24b2o15bo3bo184bo2b2o$282b2o1160b2o24bo7bo10b3o\n" +
            "186bobo$1470bo3bobobo10bo$282b2o67bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo249b3o205b2o$281bobo65b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o269bo2bo183bo2bo$280bob\n" +
            "o67b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o272bo181bo2bo$280b2o1190bo2bo14bo3bo11b2o169b3o$1458bobo\n" +
            "15bo14b4o10b4o169bo$274b2o1182b2o12bo3bo28b2ob2o167b2o$274b2o1137bo33b\n" +
            "o11bo13b4o30b2o15b2o150bobo$1414b2o30b3o73b2ob2o147bo2b2o$342bobo27bob\n" +
            "o27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27b\n" +
            "obo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo\n" +
            "27bobo27bobo27bobo27bobo27bobo198b2o30bo2b2o72b4o149bobo$342b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "230b3ob2o16b4o53b2o$343bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo231b5o4bo10bo3bo28bobo175b2o$1447bobo3bobo4b2o7bo29b2o173bo2bo$\n" +
            "316b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o51bob2o2bo3b4o2bo2bo30b\n" +
            "o13bobo3b4o150bo2bo$316b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o26b\n" +
            "2o23b2obo5bo3b2o47bo4bo2bo2b2o150b3o$1424b2o2bobo20b2o2bo3b4o2bo2bo42b\n" +
            "o3bo4bo2b2o150bo$336bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo251b2o\n" +
            "23bobo4b2o7bo8b2o13bobo14bo3bo5bo2bo150b2o$334b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o253bo24bo10bo3bo5b3o\n" +
            "b2o13b2o15b2o8b2o150bobo$316bo18b2o9bo18b2o9bo18b2o9bo18b2o9bo18b2o9bo\n" +
            "18b2o9bo18b2o9bo18b2o9bo18b2o9bo18b2o9bo18b2o9bo18b2o9bo18b2o9bo18b2o\n" +
            "9bo18b2o9bo18b2o9bo18b2o9bo18b2o9bo18b2o9bo18b2o9bo18b2o9bo18b2o9bo18b\n" +
            "2o9bo18b2o9bo18b2o9bo18b2o9bo18b2o9bo18b2o9bo18b2o9bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo20bo48b4o5b5o14bo16b2o158bo2b2o$315b3o27b3o27b3o27b3o27b3o\n" +
            "27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o\n" +
            "27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o\n" +
            "27b3o27b3o27b3o27b3o20bo57b3o22b2o169bobo$314bo3bo25bo3bo25bo3bo25bo3b\n" +
            "o25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3b\n" +
            "o25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3b\n" +
            "o25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3bo25bo3b\n" +
            "o25bo3bo25bo3bo25bo3bo17b3o81b4o9bo2bo$313bob3obo23bob3obo23bob3obo23b\n" +
            "ob3obo23bob3obo23bob3obo23bob3obo23bob3obo23bob3obo23bob3obo23bob3obo\n" +
            "23bob3obo23bob3obo23bob3obo23bob3obo23bob3obo23bob3obo23bob3obo23bob3o\n" +
            "bo23bob3obo23bob3obo23bob3obo23bob3obo23bob3obo23bob3obo23bob3obo23bob\n" +
            "3obo23bob3obo23bob3obo23bob3obo23bob3obo23bob3obo23bob3obo23bob3obo23b\n" +
            "ob3obo23bob3obo24b5o101b2ob2o12bo6b2o147b2o$314b5o25b5o25b5o25b5o25b5o\n" +
            "25b5o25b5o25b5o25b5o25b5o25b5o25b5o25b5o25b5o25b5o25b5o25b5o25b5o25b5o\n" +
            "25b5o25b5o25b5o25b5o25b5o25b5o25b5o25b5o25b5o25b5o25b5o25b5o25b5o25b5o\n" +
            "25b5o25b5o25b5o25b5o84b2o6b3ob2o5b2o9bo3bo4b2ob2o144bo2bo$1418bo29bo\n" +
            "33bo2bo4b2o5bo16b4o4b4o144bo2bo$327bobo27bobo27bobo27bobo27bobo27bobo\n" +
            "27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bo\n" +
            "bo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo\n" +
            "247bobo5b2o20bobo5b2o25bobo4bo7b2o24b2o146b3o$327b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o248bobo4bobo20bobo\n" +
            "4bobo20b3o3bo6b2o5bo174bo$328bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29b\n" +
            "o29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo223b2o24bo5b2o22bo5b2o35b3ob2o5b2o167b2o$1393b3o104b2ob2o165bobo$\n" +
            "315bo2b2o175bo2b2o655bo2b2o25bo2b2o25bo2b2o25bo2b2o25bo2b2o25bo2b2o25b\n" +
            "o2b2o25bo2b2o23b3o104b4o164bo2b2o$315bobo27bo3bobo23bo3bobo23bo3bobo\n" +
            "23bo3bobo23bo3bobo23bobo27bo3bobo23bo3bobo23bo3bobo23bo3bobo23bo3bobo\n" +
            "23bo3bobo23bo3bobo23bo3bobo23bo3bobo23bo3bobo23bo3bobo23bo3bobo23bo3bo\n" +
            "bo23bo3bobo23bo3bobo23bo3bobo23bo3bobo23bo3bobo23bo3bobo23bo3bobo23bo\n" +
            "3bobo23bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo26bo106b2o166bobo\n" +
            "$314b2o28bob2obo2bo21bob2obo2bo21bob2obo2bo21bob2obo2bo21bob2obo2bo21b\n" +
            "2o28bob2obo2bo21bob2obo2bo21bob2obo2bo21bob2obo2bo21bob2obo2bo21bob2ob\n" +
            "o2bo21bob2obo2bo21bob2obo2bo21bob2obo2bo21bob2obo2bo21bob2obo2bo21bob\n" +
            "2obo2bo21bob2obo2bo21bob2obo2bo21bob2obo2bo21bob2obo2bo21bob2obo2bo21b\n" +
            "ob2obo2bo21bob2obo2bo21bob2obo2bo21bob2obo2bo21b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o$313b2o28b8obo20b8obo20b8obo20b8obo20b8obo20b2o28b8obo\n" +
            "20b8obo20b8obo20b8obo20b8obo20b8obo20b8obo20b8obo20b8obo20b8obo20b8obo\n" +
            "20b8obo20b8obo20b8obo20b8obo20b8obo20b8obo20b8obo20b8obo20b8obo20b8obo\n" +
            "20b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o305b2o$313b2obo26b2o3bo24b2o3b\n" +
            "o24b2o3bo24b2o3bo24b2o3bo24b2obo26b2o3bo24b2o3bo24b2o3bo24b2o3bo24b2o\n" +
            "3bo24b2o3bo24b2o3bo24b2o3bo24b2o3bo24b2o3bo24b2o3bo24b2o3bo24b2o3bo24b\n" +
            "2o3bo24b2o3bo24b2o3bo24b2o3bo24b2o3bo24b2o3bo24b2o3bo24b2o3bo24b2obo\n" +
            "26b2obo26b2obo26b2obo26b2obo26b2obo26b2obo26b2obo136b2o163bo2bo$314b3o\n" +
            "27b4o26b4o26b4o26b4o26b4o26b3o27b4o26b4o26b4o26b4o26b4o26b4o26b4o26b4o\n" +
            "26b4o26b4o26b4o26b4o26b4o26b4o26b4o26b4o26b4o26b4o26b4o26b4o26b4o26b3o\n" +
            "27b3o27b3o27b3o27b3o27b3o27b3o27b3o135b4o161bo2bo$346bo29bo29bo29bo29b\n" +
            "o59bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo269bo105b2ob2o161b3o$1395b3o22bo5b2o22bo5b2o35b3ob2o5b\n" +
            "2o163bo$315b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b\n" +
            "2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o\n" +
            "3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b\n" +
            "2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o\n" +
            "23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23b2o3b2o23bo2bo20bobo4bo\n" +
            "bo20bobo4bobo20b3o3bo6b2o5bo168b2o$318bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo27b2o21bobo5b2o20bobo5b2o\n" +
            "25bobo4bo7b2o24b2o140bobo$315bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo\n" +
            "23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo\n" +
            "23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo\n" +
            "23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo23bo5bo\n" +
            "25bo22bo29bo33bo2bo4b2o5bo16b4o4b4o137bo2b2o$316b2ob2o25b2ob2o25b2ob2o\n" +
            "25b2ob2o25b2ob2o25b2ob2o25b2ob2o25b2ob2o25b2ob2o25b2ob2o25b2ob2o25b2ob\n" +
            "2o25b2ob2o25b2ob2o25b2ob2o25b2ob2o25b2ob2o25b2ob2o25b2ob2o25b2ob2o25b\n" +
            "2ob2o25b2ob2o25b2ob2o25b2ob2o25b2ob2o25b2ob2o25b2ob2o25b2ob2o16bobo6b\n" +
            "2ob2o16bobo6b2ob2o16bobo6b2ob2o16bobo6b2ob2o16bobo6b2ob2o16bobo6b2ob2o\n" +
            "16bobo6b2ob2o16bobo6b2ob2o28bo85b2o6b3ob2o5b2o9bo3bo4b2ob2o137bobo$\n" +
            "317bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27b\n" +
            "obo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo27bobo\n" +
            "27bobo27bobo27bobo27bobo27bobo17b2o8bobo17b2o8bobo17b2o8bobo17b2o8bobo\n" +
            "17b2o8bobo17b2o8bobo17b2o8bobo17b2o8bobo27b2obo101b2ob2o12bo6b2o$318bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo19bo9bo19bo9bo19bo9bo19bo9bo\n" +
            "19bo9bo19bo9bo19bo9bo19bo9bo29b2o18b3o81b4o9bo2bo148b2o$318bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo30bo\n" +
            "20bo57b3o22b2o160bo2bo$1419bo48b4o5b5o14bo16b2o149bo2bo$1431bo24bo10bo\n" +
            "3bo5b3ob2o13b2o15b2o8b2o140b3o$1430b2o23bobo4b2o7bo8b2o13bobo14bo3bo5b\n" +
            "o2bo140bo$1111bo29bo29bo29bo29bo29bo29bo29bo104b2o2bobo20b2o2bo3b4o2bo\n" +
            "2bo42bo3bo4bo2b2o138b2o$318b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o9b2o17b2o9b2o17b2o9b2o17b2o9b2o17b2o9b2o17b2o9b2o\n" +
            "17b2o9b2o17b2o9b2o17b2o28b2o28b2o26b2o23b2obo5bo3b2o47bo4bo2bo2b2o138b\n" +
            "obo$318b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "10b2o16b2o10b2o16b2o10b2o16b2o10b2o16b2o10b2o16b2o10b2o16b2o10b2o16b2o\n" +
            "10b2o16b2o28b2o28b2o51bob2o2bo3b4o2bo2bo30bo13bobo3b4o137bo2b2o$1449bo\n" +
            "bo3bobo4b2o7bo29b2o160bobo$1447b5o4bo10bo3bo28bobo$1446b3ob2o16b4o53b\n" +
            "2o137b2o$1447bo2b2o72b4o134bo2bo$1119b3o27b3o27b3o27b3o27b3o27b3o27b3o\n" +
            "27b3o82b2o32b3o73b2ob2o132bo2bo$1106b2o10b5o13b2o10b5o13b2o10b5o13b2o\n" +
            "10b5o13b2o10b5o13b2o10b5o13b2o10b5o13b2o10b5o80bobo33bo11bo13b4o30b2o\n" +
            "15b2o134b3o$1103b3ob2o9b3ob2o9b3ob2o9b3ob2o9b3ob2o9b3ob2o9b3ob2o9b3ob\n" +
            "2o9b3ob2o9b3ob2o9b3ob2o9b3ob2o9b3ob2o9b3ob2o9b3ob2o9b3ob2o81bo44b2o12b\n" +
            "o3bo28b2ob2o151bo$1103b5o13b2o10b5o13b2o10b5o13b2o10b5o13b2o10b5o13b2o\n" +
            "10b5o13b2o10b5o13b2o10b5o13b2o127bobo15bo14b4o10b4o151b2o$1104b3o27b3o\n" +
            "27b3o27b3o27b3o27b3o27b3o27b3o157bo2bo14bo3bo11b2o151bobo$1496bo162bo\n" +
            "2b2o$1492bo2bo63bo2bo97bobo$1473b3o87bo6b2o$346bo1125bo3bobobo10bo67bo\n" +
            "3bo4b2ob2o88b2o$344b2o1100b2o24bo7bo10b3o66b4o4b4o87bo2bo$345b2o1098b\n" +
            "4o24b2o15bo3bo74b2o87bo2bo$1445b2ob2o37b3o4bo61b2o101b3o$1447b2o29bo8b\n" +
            "3obob2o165bo$1487b2o3bo62bo2bo7b3o90b2o$1456b2o31bobo62b2ob2o5bo3b2o\n" +
            "88bobo$1429b2o24b4o96bob5o2bobo2b2o85bo2b2o$1428bobo24b2ob2o96bo2b3obo\n" +
            "5bo87bobo$1430bo15b3ob2o5b2o27b2o5b4o63bo3bo2b2o$1445b2o5bo31b2ob2o3bo\n" +
            "3bo67bo93b2o$1435bo8bo7b2o30b4o8bo69bo89bo2bo$1434bobo8b2o5bo32b2o5bo\n" +
            "2bo48bo110bo2bo$1433bo12b3ob2o5b2o85bobo23b2o84b3o$1435bo19b2ob2o3b2o\n" +
            "5bo2bo70b2o22b2ob2o84bo$301bo119bo1033b4o3b4o8bo77b2o14b4o84b2o$299b2o\n" +
            "118b2o1003b4o28b2o4b2ob2o3bo3bo75b2ob2o14b2o84bobo$300b2o118b2o1001b6o\n" +
            "10b2o23b2o5b4o54bo20b4o99bo2b2o$1423b4ob2o8bobo88bobo19b2o101bobo$\n" +
            "1427b2o11bo88b2o12b2o$1467bobo72b4o109b2o$1465b2o3bo71b2ob2o106bo2bo$\n" +
            "1444b2o10bo8b3obob2o60b3ob2o5b2o106bo2bo$1443bobo19b3o4bo59b2o5bo113b\n" +
            "3o$1445bo5b2o15bo3bo58bo7b2o113bo$195b2o1253bo7bo10b3o60b2o5bo113b2o$\n" +
            "195bo1254bo3bobobo10bo63b3ob2o5b2o106bobo$188bo4bobo1255b3o88b2ob2o\n" +
            "103bo2b2o$187bobo3b2o1275bo2bo68b4o105bobo$170b2o15b2obo1283bo68b2o$\n" +
            "170bobo14b2ob2o64bo1213bo3bo54bo2bo119b2o$161b2o2b2o6bo13b2obo63b2o\n" +
            "1198b4o13b4o58bo116bo2bo$161b2obo2bo2bo2bo13bobo65b2o1196bo3bo26bo44bo\n" +
            "3bo115bo2bo$165b2o6bo8bo5bo1268bo26bobo43b4o116b3o$170bobo7bobo1270bo\n" +
            "2bo27b2o165bo$170b2o9b2o1467b2o$207b2o1440bobo$207b2o1438bo2b2o$398b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o198bobo$207bo190b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o\n" +
            "28b2o28b2o28b2o28b2o$189bo16bobo1440b2o$190bo15bobo1272b3o44bo2bo115bo\n" +
            "2bo$188b3o16bo1273bo50bo113bo2bo$96b2o1384bo45bo3bo114b3o$97bo87b2o\n" +
            "1342b4o115bo$97bobo5b2o78b2o17b2obob2o1436b2o$98b2o5bo2bo95bo5bo1435bo\n" +
            "bo$89b2o18bo9bobo83bo3bo1217b2o114b2o99bo2b2o$89b2o18bo7bo3bo75bo8b3o\n" +
            "1216b2ob2o13b2o87bo8b2ob2o99bobo$75bo10b2o21bo7bo77bobo1227b4o13b4o84b\n" +
            "obo4bo3b4o$75bobo7b3o17bo2bo7bo4bo8b2o64b2o1228b2o14b2ob2o82bo2bo5bo3b\n" +
            "2o102b2o$78b2o6b2o17b2o10bo12b2o1312b2o83bo6bo2bo104bo2bo$64b2o12b2o9b\n" +
            "2o5b2o19bo3bo1301bo105bo2bo5bo3b2o99bo2bo$64b2o12b2o9b2o5bobo9bobo8bob\n" +
            "o1300b3o105bobo4bo3b4o99b3o$75bobo20bo9b2o1311bob2o3bo11bo91bo8b2ob2o\n" +
            "99bo$75bo11bo10b2o9bo97b2o1212bo6bo10b4o100b2o99b2o$85bobo82bo36bobo\n" +
            "1205bo6bo14b5obo82b3o114bobo$86b2o81bobo35bobo1206b2o18bo6b2o81bo114bo\n" +
            "2b2o$170bo1244b2o18bo3bob3o83bo23b2o89bobo$167bo1233bo34bo3b3o106b2ob\n" +
            "2o$166bobo1230bo3bo33bo111b4o16b2o72b2o$15bo98bo52bo1236bo5bo130b3o6b\n" +
            "2o15b2ob2o69bo2bo$16b2o76bo18b2o49bo38b5o1191bo4bo6b2o30b2o8b2o5bo2bo\n" +
            "77bo25b4o69bo2bo$15b2o78bo17bobo47bobo36bob3obo1191b5o5b2o22b4o4b4o6b\n" +
            "4o8bo77bo25b2o71b3o$93b3o68bo38bo3bo1218bo2bo3bo3bo4b2ob2o5b2ob2o3bo3b\n" +
            "o177bo$97b2o4b2o21b2o33bo42b3o1223bo6bo6b2o8b2o5b4o93bo3bo78b2o$96bobo\n" +
            "5bo21bobo31bobo42bo1212bo7bo3bo2bo2bo121b2o5b3o72bobo$96bo7bobo9bo4b2o\n" +
            "6bo7b2o22bo1243b2o9b3o3bo4b4o19bo102b2o9bob3o69bo2b2o$18bo76b2o8b2o8bo\n" +
            "bo2bo2bo2bo2bo7b2o1266b2o9b2o5b2o24b2o101bo6bo8b2o69bobo$19b2o94b2obob\n" +
            "3o6bo1276bo8bo6b3o23bob2o7b2o90bo3bo3b8obo$18b2o95b2ob2o6bobo76b2o\n" +
            "1209b2o5b2o23bobo7bo2b2o89bo3bo7b4o72b2o$115b2obo7b2o77b2o1193bo15b3o\n" +
            "3bo4b4o17b2o3bo3b3o2bo93bo8bo72bo2bo$115bobo1283b2o15bo7bo3bo19bob3o2b\n" +
            "o4bo174bo2bo$116bo1283b2o28bo26b5o96bo2bo76b3o$1426bo2bo28b2o102bo6b2o\n" +
            "68bo$1558bo3bo4b2ob2o66b2o$1437bobo20bo2bo95b4o4b4o66bobo$1437b2o25bo\n" +
            "103b2o65bo2b2o$1438bo3bo2bo14bo3bo171bobo$1446bo14b4o$1442bo3bo190b2o$\n" +
            "21b3o1398bobo18b4o188bo2bo$20bo1401b2o210bo2bo$20bo4bo1397bo211b3o$20b\n" +
            "o2bobo1409b4o197bo$22b2o1394b2o4bo9bo3bo196b2o$1385bo32b2o5b2o11bo195b\n" +
            "obo$23bo1362b2o34b3o5b2o2bo2bo194bo2b2o$22bo1362b2o34b3o6b3o200bobo$\n" +
            "22bo1399b3o5b2o2bo2bo$196bo1221b2o5b2o11bo195b2o$11b2o181b2o1196bobo\n" +
            "22bo2bo3bo9bo3bo193bo2bo$11b2o111bo70b2o1195b2o23bo2bo14b4o192bo2bo$\n" +
            "125bo1267bo24b3o211b3o$123b3o9bo2bo116bo2bo56bo2bo56bo2bo56bo2bo56bo2b\n" +
            "o56bo2bo56bo2bo56bo2bo56bo2bo56bo2bo56bo2bo56bo2bo56bo2bo56bo2bo56bo2b\n" +
            "o56bo2bo56bo2bo56bo2bo56bo2bo84b2o208bo$25bo108bo119bo59bo59bo59bo59bo\n" +
            "59bo59bo59bo59bo59bo59bo59bo59bo59bo59bo59bo59bo59bo59bo87b4o206b2o$\n" +
            "23b2obo3b2o102bo3bo115bo3bo55bo3bo55bo3bo55bo3bo55bo3bo55bo3bo55bo3bo\n" +
            "55bo3bo55bo3bo55bo3bo55bo3bo55bo3bo55bo3bo55bo3bo55bo3bo55bo3bo55bo3bo\n" +
            "55bo3bo55bo3bo83b2ob2o204bobo$10bo12bobobo2b3o101b4o116b4o56b4o56b4o\n" +
            "56b4o56b4o56b4o56b4o56b4o56b4o56b4o56b4o56b4o56b4o56b4o56b4o56b4o56b4o\n" +
            "56b4o56b4o86b2o203bo2b2o$4bo2b3obo8b3o2b4ob3o59b2o1536bobo$4b5o2b2o7b\n" +
            "2o6bo3bo58bobo$5bob2ob2o7bob4o7b2o57bo1296b2o41b4o196b2o$19bob3o9b2o\n" +
            "55b2o1296bobo39bo3bo194bo2bo$20b3o5b3obo2bo1352bo45bo193bo2bo$29b4o\n" +
            "1397bo2bo195b3o$29b2obo3bo1407b2o184bo$30b2ob3o1407b4o182b2o$1431bo11b\n" +
            "2ob2o180bobo$137b2o1290b2obo3bo2bo5b2o179bo2b2o$137bo1289b5o4bo3bo186b\n" +
            "obo$36b2o100b3o1286bo2bo4bo4b2o$36b2o2b2o98bo1286b5o4bo3bo187b2o$40b2o\n" +
            "1387b2obo3bo2bo5b2o179bo2bo$3b3o34bo1390bo11b2ob2o177bo2bo$3b3o1377b2o\n" +
            "58b4o179b3o$5bo1368b4o4b4o58b2o181bo$6bo2b2ob2o1359bo3bo4b2ob2o46b2o\n" +
            "17b2o172b2o$3o3b4o3bo30b2o1331bo6b2o47bobo15b4o170bobo$6bob2obobo30b2o\n" +
            "1327bo2bo56bo17b2ob2o14b2o151bo2b2o$5bo1447b2o14b4o151bobo$1371b2o96b\n" +
            "2ob2o$1371b2o8b2o65b2o21b2o152b2o$1370bo3bo5bo2bo63b2o174bo2bo$1371bo\n" +
            "3bo4bo2b2o237bo2bo$1371bo4bo2bo2b2o62b2o175b3o$36b2o1335bobo3b4o85b2o\n" +
            "154bo$22b2o12b2o1424b3o3bobo152b2o$21bo2bo1335b2o97b3o6bob2o150bobo$\n" +
            "21bob2o1333bo24b2o74bo9b2o149bo2b2o$19b4o1336bobo20b4o73b3o7bo151bobo$\n" +
            "18bo1341bo4b2o15b2ob2o$17bo3b2o1341b4o16b2o236b2o$18bo3bo1322bo18b2ob\n" +
            "2o101b2o148bo2bo$19b3o1322bo21b2o93b4o4b4o146bo2bo$1344b3o113bo3bo4b2o\n" +
            "b2o146b3o$1464bo6b2o148bo$91b2o1265b2o100bo2bo156b2o$91bobo1246b2o5bo\n" +
            "8b2ob2o258bobo$91bo1248b2o3bobo4bo3b4o257bo2b2o$1335b2o7bo2bo5bo3b2o\n" +
            "259bobo$1344bo6bo2bo$1344bo2bo5bo3b2o260b2o$1315bo24b2o3bobo4bo3b4o\n" +
            "257bo2bo$1314bo24bo2bo4bo8b2ob2o255bo2bo$1314b3o22bob2o15b2o257b3o$\n" +
            "1340b2o276bo$1617b2o$1344b4o268bobo$1343bo3bo266bo2b2o$1347bo267bobo$\n" +
            "137b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b\n" +
            "2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o28b2o64bo2bo$138bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo337b2o$135b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o\n" +
            "27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o\n" +
            "27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o27b3o\n" +
            "27b3o27b3o336bo2bo$135bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo\n" +
            "29bo29bo29bo29bo29bo29bo29bo29bo29bo29bo337bo2bo$1614b3o$1353b2o260bo$\n" +
            "1313bo37b2ob2o259bo$1312b2o37b4o261bo$1312bobo37b2o261b3o$1615b2o$\n" +
            "1341bo22b4o245b3o$1340bo12bo9bo3bo246bo$1340bo13b2o11bo244bo$1345bo5b\n" +
            "3o5b2o2bo2bo246bobobo$1350b3o6b3o253bo2bo$1351b3o5b2o2bo2bo251b2o$\n" +
            "1354b2o11bo252bo$1353bo9bo3bo250b4o$1364b4o249bo4bo$1619bo2bo$1619bo2b\n" +
            "o$1358bo13b4o245bo$1357b2o12bo3bo239bob4o$1357bobo15bo14b4o221bo3bo$\n" +
            "1371bo2bo14bo3bo224bo$1393bo222bobo$1389bo2bo$1370b3o244b3o$1369bo3bob\n" +
            "obo10bo229b2o$1369bo7bo10b3o226b3o$1370b2o15bo3bo$1384b3o4bo224bobo$\n" +
            "1375bo8b3obob2o226bo$1384b2o3bo225bo3bo$1386bobo226bob4o$1621bo$1619bo\n" +
            "2bo$1383b2o5b4o225bo2bo$1381b2ob2o3bo3bo223bo4bo$348b2o1031b4o8bo224b\n" +
            "4o16bo25b2o$348b2o1032b2o5bo2bo227bo15b2obo21b3ob2o$1618b2o12b2obo4b2o\n" +
            "19b5o$1615bo2bo7b2o5bobo6bo14bo4b3o$1615bobo8b2o4b3o7bo6bo2b3o2bo$\n" +
            "1625b3ob3ob3obobo3b2o3bo2b6o2b2o$351b2o1271b2o6bo4b4ob2ob2o13b2o$351bo\n" +
            "bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3b\n" +
            "o3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo2b3o5b5o3bo2bob\n" +
            "2ob3o2bo4b4o$352bobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobo\n" +
            "bobobobobobobobobobobobobobob6o3bo6bo2bo2bo4b2obo2bobobo$353b2obobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "obobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobobob\n" +
            "ob6o3bo6bo2bo2bo4b2obo2bobobo$357bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3b\n" +
            "o3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo3bo\n" +
            "3bo3bo3bo3bo3bo2b3o5b5o3bo2bob2ob3o2bo4b4o$1624b2o6bo4b4ob2ob2o13b2o$\n" +
            "1625b3ob3ob3obobo3b2o3bo2b6o2b2o$1626b2o4b3o7bo6bo2b3o2bo$1626b2o5bobo\n" +
            "6bo14bo4b3o$1618b3o2bo8b2obo4b2o19b5o$1613b5obo2bobo11b2obo21b3ob2o$\n" +
            "1613b6o2bo16bo25b2o$1614b4o4bo2b5o$359b2o1261bo6bo$359bo1269bo$360b3o\n" +
            "1265bo$362bo1261b2o$1622b2ob2o$1622b4o$1623b2o!"
    );



}

