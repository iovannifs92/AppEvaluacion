package com.sistemas.evaluacion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    private static final String CREATE_TABLE="CREATE TABLE \"world\" (\n" +
            "  \"id\" int(11) NOT NULL,\n" +
            "  \"name\" varchar(75) NOT NULL DEFAULT \"\",\n" +
            "  \"alpha_2\" char(2) NOT NULL DEFAULT \"\",\n" +
            "  \"alpha_3\" char(3) NOT NULL DEFAULT \"\",\n" +
            "  PRIMARY KEY (\"id\"))";

    private static final String INSERT_INTO="INSERT INTO \"world\" (\"id\", \"name\", \"alpha_2\", \"alpha_3\") VALUES\n" +
            "(4,\"Afganistán\",\"af\",\"afg\"),\n" +
            "(248,\"Åland\",\"ax\",\"ala\"),\n" +
            "(8,\"Albania\",\"al\",\"alb\"),\n" +
            "(276,\"Alemania\",\"de\",\"deu\"),\n" +
            "(20,\"Andorra\",\"ad\",\"and\"),\n" +
            "(24,\"Angola\",\"ao\",\"ago\"),\n" +
            "(660,\"Anguila\",\"ai\",\"aia\"),\n" +
            "(10,\"Antártida\",\"aq\",\"ata\"),\n" +
            "(28,\"Antigua y Barbuda\",\"ag\",\"atg\"),\n" +
            "(682,\"Arabia Saudita\",\"sa\",\"sau\"),\n" +
            "(12,\"Argelia\",\"dz\",\"dza\"),\n" +
            "(32,\"Argentina\",\"ar\",\"arg\"),\n" +
            "(51,\"Armenia\",\"am\",\"arm\"),\n" +
            "(533,\"Aruba\",\"aw\",\"abw\"),\n" +
            "(36,\"Australia\",\"au\",\"aus\"),\n" +
            "(40,\"Austria\",\"at\",\"aut\"),\n" +
            "(31,\"Azerbaiyán\",\"az\",\"aze\"),\n" +
            "(44,\"Bahamas\",\"bs\",\"bhs\"),\n" +
            "(50,\"Bangladés\",\"bd\",\"bgd\"),\n" +
            "(52,\"Barbados\",\"bb\",\"brb\"),\n" +
            "(48,\"Baréin\",\"bh\",\"bhr\"),\n" +
            "(56,\"Bélgica\",\"be\",\"bel\"),\n" +
            "(84,\"Belice\",\"bz\",\"blz\"),\n" +
            "(204,\"Benín\",\"bj\",\"ben\"),\n" +
            "(60,\"Bermudas\",\"bm\",\"bmu\"),\n" +
            "(112,\"Bielorrusia\",\"by\",\"blr\"),\n" +
            "(68,\"Bolivia\",\"bo\",\"bol\"),\n" +
            "(535,\"Bonaire, San Eustaquio y Saba\",\"bq\",\"bes\"),\n" +
            "(70,\"Bosnia y Herzegovina\",\"ba\",\"bih\"),\n" +
            "(72,\"Botsuana\",\"bw\",\"bwa\"),\n" +
            "(76,\"Brasil\",\"br\",\"bra\"),\n" +
            "(96,\"Brunéi\",\"bn\",\"brn\"),\n" +
            "(100,\"Bulgaria\",\"bg\",\"bgr\"),\n" +
            "(854,\"Burkina Faso\",\"bf\",\"bfa\"),\n" +
            "(108,\"Burundi\",\"bi\",\"bdi\"),\n" +
            "(64,\"Bután\",\"bt\",\"btn\"),\n" +
            "(132,\"Cabo Verde\",\"cv\",\"cpv\"),\n" +
            "(116,\"Camboya\",\"kh\",\"khm\"),\n" +
            "(120,\"Camerún\",\"cm\",\"cmr\"),\n" +
            "(124,\"Canadá\",\"ca\",\"can\"),\n" +
            "(634,\"Catar\",\"qa\",\"qat\"),\n" +
            "(148,\"Chad\",\"td\",\"tcd\"),\n" +
            "(152,\"Chile\",\"cl\",\"chl\"),\n" +
            "(156,\"China\",\"cn\",\"chn\"),\n" +
            "(196,\"Chipre\",\"cy\",\"cyp\"),\n" +
            "(170,\"Colombia\",\"co\",\"col\"),\n" +
            "(174,\"Comoras\",\"km\",\"com\"),\n" +
            "(408,\"Corea del Norte\",\"kp\",\"prk\"),\n" +
            "(410,\"Corea del Sur\",\"kr\",\"kor\"),\n" +
            "(384,\"Costa de Marfil\",\"ci\",\"civ\"),\n" +
            "(188,\"Costa Rica\",\"cr\",\"cri\"),\n" +
            "(191,\"Croacia\",\"hr\",\"hrv\"),\n" +
            "(192,\"Cuba\",\"cu\",\"cub\"),\n" +
            "(531,\"Curazao\",\"cw\",\"cuw\"),\n" +
            "(208,\"Dinamarca\",\"dk\",\"dnk\"),\n" +
            "(212,\"Dominica\",\"dm\",\"dma\"),\n" +
            "(218,\"Ecuador\",\"ec\",\"ecu\"),\n" +
            "(818,\"Egipto\",\"eg\",\"egy\"),\n" +
            "(222,\"El Salvador\",\"sv\",\"slv\"),\n" +
            "(784,\"Emiratos Árabes Unidos\",\"ae\",\"are\"),\n" +
            "(232,\"Eritrea\",\"er\",\"eri\"),\n" +
            "(703,\"Eslovaquia\",\"sk\",\"svk\"),\n" +
            "(705,\"Eslovenia\",\"si\",\"svn\"),\n" +
            "(724,\"España\",\"es\",\"esp\"),\n" +
            "(840,\"Estados Unidos\",\"us\",\"usa\"),\n" +
            "(233,\"Estonia\",\"ee\",\"est\"),\n" +
            "(231,\"Etiopía\",\"et\",\"eth\"),\n" +
            "(608,\"Filipinas\",\"ph\",\"phl\"),\n" +
            "(246,\"Finlandia\",\"fi\",\"fin\"),\n" +
            "(242,\"Fiyi\",\"fj\",\"fji\"),\n" +
            "(250,\"Francia\",\"fr\",\"fra\"),\n" +
            "(266,\"Gabón\",\"ga\",\"gab\"),\n" +
            "(270,\"Gambia\",\"gm\",\"gmb\"),\n" +
            "(268,\"Georgia\",\"ge\",\"geo\"),\n" +
            "(288,\"Ghana\",\"gh\",\"gha\"),\n" +
            "(292,\"Gibraltar\",\"gi\",\"gib\"),\n" +
            "(308,\"Granada\",\"gd\",\"grd\"),\n" +
            "(300,\"Grecia\",\"gr\",\"grc\"),\n" +
            "(304,\"Groenlandia\",\"gl\",\"grl\"),\n" +
            "(312,\"Guadalupe\",\"gp\",\"glp\"),\n" +
            "(316,\"Guam\",\"gu\",\"gum\"),\n" +
            "(320,\"Guatemala\",\"gt\",\"gtm\"),\n" +
            "(254,\"Guayana Francesa\",\"gf\",\"guf\"),\n" +
            "(831,\"Guernsey\",\"gg\",\"ggy\"),\n" +
            "(324,\"Guinea\",\"gn\",\"gin\"),\n" +
            "(624,\"Guinea-Bisáu\",\"gw\",\"gnb\"),\n" +
            "(226,\"Guinea Ecuatorial\",\"gq\",\"gnq\"),\n" +
            "(328,\"Guyana\",\"gy\",\"guy\"),\n" +
            "(332,\"Haití\",\"ht\",\"hti\"),\n" +
            "(340,\"Honduras\",\"hn\",\"hnd\"),\n" +
            "(344,\"Hong Kong\",\"hk\",\"hkg\"),\n" +
            "(348,\"Hungría\",\"hu\",\"hun\"),\n" +
            "(356,\"India\",\"in\",\"ind\"),\n" +
            "(360,\"Indonesia\",\"id\",\"idn\"),\n" +
            "(368,\"Irak\",\"iq\",\"irq\"),\n" +
            "(364,\"Irán\",\"ir\",\"irn\"),\n" +
            "(372,\"Irlanda\",\"ie\",\"irl\"),\n" +
            "(74,\"Isla Bouvet\",\"bv\",\"bvt\"),\n" +
            "(833,\"Isla de Man\",\"im\",\"imn\"),\n" +
            "(162,\"Isla de Navidad\",\"cx\",\"cxr\"),\n" +
            "(352,\"Islandia\",\"is\",\"isl\"),\n" +
            "(136,\"Islas Caimán\",\"ky\",\"cym\"),\n" +
            "(166,\"Islas Cocos\",\"cc\",\"cck\"),\n" +
            "(184,\"Islas Cook\",\"ck\",\"cok\"),\n" +
            "(234,\"Islas Feroe\",\"fo\",\"fro\"),\n" +
            "(239,\"Islas Georgias del Sur y Sandwich del Sur\",\"gs\",\"sgs\"),\n" +
            "(334,\"Islas Heard y McDonald\",\"hm\",\"hmd\"),\n" +
            "(238,\"Islas Malvinas\",\"fk\",\"flk\"),\n" +
            "(580,\"Islas Marianas del Norte\",\"mp\",\"mnp\"),\n" +
            "(584,\"Islas Marshall\",\"mh\",\"mhl\"),\n" +
            "(612,\"Islas Pitcairn\",\"pn\",\"pcn\"),\n" +
            "(90,\"Islas Salomón\",\"sb\",\"slb\"),\n" +
            "(796,\"Islas Turcas y Caicos\",\"tc\",\"tca\"),\n" +
            "(581,\"Islas ultramarinas de Estados Unidos\",\"um\",\"umi\"),\n" +
            "(92,\"Islas Vírgenes Británicas\",\"vg\",\"vgb\"),\n" +
            "(850,\"Islas Vírgenes de los Estados Unidos\",\"vi\",\"vir\"),\n" +
            "(376,\"Israel\",\"il\",\"isr\"),\n" +
            "(380,\"Italia\",\"it\",\"ita\"),\n" +
            "(388,\"Jamaica\",\"jm\",\"jam\"),\n" +
            "(392,\"Japón\",\"jp\",\"jpn\"),\n" +
            "(832,\"Jersey\",\"je\",\"jey\"),\n" +
            "(400,\"Jordania\",\"jo\",\"jor\"),\n" +
            "(398,\"Kazajistán\",\"kz\",\"kaz\"),\n" +
            "(404,\"Kenia\",\"ke\",\"ken\"),\n" +
            "(417,\"Kirguistán\",\"kg\",\"kgz\"),\n" +
            "(296,\"Kiribati\",\"ki\",\"kir\"),\n" +
            "(414,\"Kuwait\",\"kw\",\"kwt\"),\n" +
            "(418,\"Laos\",\"la\",\"lao\"),\n" +
            "(426,\"Lesoto\",\"ls\",\"lso\"),\n" +
            "(428,\"Letonia\",\"lv\",\"lva\"),\n" +
            "(422,\"Líbano\",\"lb\",\"lbn\"),\n" +
            "(430,\"Liberia\",\"lr\",\"lbr\"),\n" +
            "(434,\"Libia\",\"ly\",\"lby\"),\n" +
            "(438,\"Liechtenstein\",\"li\",\"lie\"),\n" +
            "(440,\"Lituania\",\"lt\",\"ltu\"),\n" +
            "(442,\"Luxemburgo\",\"lu\",\"lux\"),\n" +
            "(446,\"Macao\",\"mo\",\"mac\"),\n" +
            "(807,\"Macedonia del Norte\",\"mk\",\"mkd\"),\n" +
            "(450,\"Madagascar\",\"mg\",\"mdg\"),\n" +
            "(458,\"Malasia\",\"my\",\"mys\"),\n" +
            "(454,\"Malaui\",\"mw\",\"mwi\"),\n" +
            "(462,\"Maldivas\",\"mv\",\"mdv\"),\n" +
            "(466,\"Malí\",\"ml\",\"mli\"),\n" +
            "(470,\"Malta\",\"mt\",\"mlt\"),\n" +
            "(504,\"Marruecos\",\"ma\",\"mar\"),\n" +
            "(474,\"Martinica\",\"mq\",\"mtq\"),\n" +
            "(480,\"Mauricio\",\"mu\",\"mus\"),\n" +
            "(478,\"Mauritania\",\"mr\",\"mrt\"),\n" +
            "(175,\"Mayotte\",\"yt\",\"myt\"),\n" +
            "(484,\"México\",\"mx\",\"mex\"),\n" +
            "(583,\"Micronesia\",\"fm\",\"fsm\"),\n" +
            "(498,\"Moldavia\",\"md\",\"mda\"),\n" +
            "(492,\"Mónaco\",\"mc\",\"mco\"),\n" +
            "(496,\"Mongolia\",\"mn\",\"mng\"),\n" +
            "(499,\"Montenegro\",\"me\",\"mne\"),\n" +
            "(500,\"Montserrat\",\"ms\",\"msr\"),\n" +
            "(508,\"Mozambique\",\"mz\",\"moz\"),\n" +
            "(104,\"Birmania\",\"mm\",\"mmr\"),\n" +
            "(516,\"Namibia\",\"na\",\"nam\"),\n" +
            "(520,\"Nauru\",\"nr\",\"nru\"),\n" +
            "(524,\"Nepal\",\"np\",\"npl\"),\n" +
            "(558,\"Nicaragua\",\"ni\",\"nic\"),\n" +
            "(562,\"Níger\",\"ne\",\"ner\"),\n" +
            "(566,\"Nigeria\",\"ng\",\"nga\"),\n" +
            "(570,\"Niue\",\"nu\",\"niu\"),\n" +
            "(574,\"Norfolk\",\"nf\",\"nfk\"),\n" +
            "(578,\"Noruega\",\"no\",\"nor\"),\n" +
            "(540,\"Nueva Caledonia\",\"nc\",\"ncl\"),\n" +
            "(554,\"Nueva Zelanda\",\"nz\",\"nzl\"),\n" +
            "(512,\"Omán\",\"om\",\"omn\"),\n" +
            "(528,\"Países Bajos\",\"nl\",\"nld\"),\n" +
            "(586,\"Pakistán\",\"pk\",\"pak\"),\n" +
            "(585,\"Palaos\",\"pw\",\"plw\"),\n" +
            "(275,\"Palestina\",\"ps\",\"pse\"),\n" +
            "(591,\"Panamá\",\"pa\",\"pan\"),\n" +
            "(598,\"Papúa Nueva Guinea\",\"pg\",\"png\"),\n" +
            "(600,\"Paraguay\",\"py\",\"pry\"),\n" +
            "(604,\"Perú\",\"pe\",\"per\"),\n" +
            "(258,\"Polinesia Francesa\",\"pf\",\"pyf\"),\n" +
            "(616,\"Polonia\",\"pl\",\"pol\"),\n" +
            "(620,\"Portugal\",\"pt\",\"prt\"),\n" +
            "(630,\"Puerto Rico\",\"pr\",\"pri\"),\n" +
            "(826,\"Reino Unido\",\"gb\",\"gbr\"),\n" +
            "(732,\"República Árabe Saharaui Democrática\",\"eh\",\"esh\"),\n" +
            "(140,\"República Centroafricana\",\"cf\",\"caf\"),\n" +
            "(203,\"República Checa\",\"cz\",\"cze\"),\n" +
            "(178,\"República del Congo\",\"cg\",\"cog\"),\n" +
            "(180,\"República Democrática del Congo\",\"cd\",\"cod\"),\n" +
            "(214,\"República Dominicana\",\"do\",\"dom\"),\n" +
            "(638,\"Reunión\",\"re\",\"reu\"),\n" +
            "(646,\"Ruanda\",\"rw\",\"rwa\"),\n" +
            "(642,\"Rumania\",\"ro\",\"rou\"),\n" +
            "(643,\"Rusia\",\"ru\",\"rus\"),\n" +
            "(882,\"Samoa\",\"ws\",\"wsm\"),\n" +
            "(16,\"Samoa Americana\",\"as\",\"asm\"),\n" +
            "(652,\"San Bartolomé\",\"bl\",\"blm\"),\n" +
            "(659,\"San Cristóbal y Nieves\",\"kn\",\"kna\"),\n" +
            "(674,\"San Marino\",\"sm\",\"smr\"),\n" +
            "(663,\"San Martín\",\"mf\",\"maf\"),\n" +
            "(666,\"San Pedro y Miquelón\",\"pm\",\"spm\"),\n" +
            "(670,\"San Vicente y las Granadinas\",\"vc\",\"vct\"),\n" +
            "(654,\"Santa Elena, Ascensión y Tristán de Acuña\",\"sh\",\"shn\"),\n" +
            "(662,\"Santa Lucía\",\"lc\",\"lca\"),\n" +
            "(678,\"Santo Tomé y Príncipe\",\"st\",\"stp\"),\n" +
            "(686,\"Senegal\",\"sn\",\"sen\"),\n" +
            "(688,\"Serbia\",\"rs\",\"srb\"),\n" +
            "(690,\"Seychelles\",\"sc\",\"syc\"),\n" +
            "(694,\"Sierra Leona\",\"sl\",\"sle\"),\n" +
            "(702,\"Singapur\",\"sg\",\"sgp\"),\n" +
            "(534,\"Sint Maarten\",\"sx\",\"sxm\"),\n" +
            "(760,\"Siria\",\"sy\",\"syr\"),\n" +
            "(706,\"Somalia\",\"so\",\"som\"),\n" +
            "(144,\"Sri Lanka\",\"lk\",\"lka\"),\n" +
            "(748,\"Suazilandia\",\"sz\",\"swz\"),\n" +
            "(710,\"Sudáfrica\",\"za\",\"zaf\"),\n" +
            "(729,\"Sudán\",\"sd\",\"sdn\"),\n" +
            "(728,\"Sudán del Sur\",\"ss\",\"ssd\"),\n" +
            "(752,\"Suecia\",\"se\",\"swe\"),\n" +
            "(756,\"Suiza\",\"ch\",\"che\"),\n" +
            "(740,\"Surinam\",\"sr\",\"sur\"),\n" +
            "(744,\"Svalbard y Jan Mayen\",\"sj\",\"sjm\"),\n" +
            "(764,\"Tailandia\",\"th\",\"tha\"),\n" +
            "(158,\"Taiwán (República de China)\",\"tw\",\"twn\"),\n" +
            "(834,\"Tanzania\",\"tz\",\"tza\"),\n" +
            "(762,\"Tayikistán\",\"tj\",\"tjk\"),\n" +
            "(86,\"Territorio Británico del Océano Índico\",\"io\",\"iot\"),\n" +
            "(260,\"Tierras Australes y Antárticas Francesas\",\"tf\",\"atf\"),\n" +
            "(626,\"Timor Oriental\",\"tl\",\"tls\"),\n" +
            "(768,\"Togo\",\"tg\",\"tgo\"),\n" +
            "(772,\"Tokelau\",\"tk\",\"tkl\"),\n" +
            "(776,\"Tonga\",\"to\",\"ton\"),\n" +
            "(780,\"Trinidad y Tobago\",\"tt\",\"tto\"),\n" +
            "(788,\"Túnez\",\"tn\",\"tun\"),\n" +
            "(795,\"Turkmenistán\",\"tm\",\"tkm\"),\n" +
            "(792,\"Turquía\",\"tr\",\"tur\"),\n" +
            "(798,\"Tuvalu\",\"tv\",\"tuv\"),\n" +
            "(804,\"Ucrania\",\"ua\",\"ukr\"),\n" +
            "(800,\"Uganda\",\"ug\",\"uga\"),\n" +
            "(858,\"Uruguay\",\"uy\",\"ury\"),\n" +
            "(860,\"Uzbekistán\",\"uz\",\"uzb\"),\n" +
            "(548,\"Vanuatu\",\"vu\",\"vut\"),\n" +
            "(336,\"Vaticano, Ciudad del\",\"va\",\"vat\"),\n" +
            "(862,\"Venezuela\",\"ve\",\"ven\"),\n" +
            "(704,\"Vietnam\",\"vn\",\"vnm\"),\n" +
            "(876,\"Wallis y Futuna\",\"wf\",\"wlf\"),\n" +
            "(887,\"Yemen\",\"ye\",\"yem\"),\n" +
            "(262,\"Yibuti\",\"dj\",\"dji\"),\n" +
            "(894,\"Zambia\",\"zm\",\"zmb\"),\n" +
            "(716,\"Zimbabue\",\"zw\",\"zwe\")";


    private static final String DB_NAME="paises.sqlite";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase db;


    public ConexionSQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(INSERT_INTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
