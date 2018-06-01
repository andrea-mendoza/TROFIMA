package com.ucbcba.demo.Controllers;

import com.ucbcba.demo.Entities.User;
import com.ucbcba.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationInit(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, @RequestParam("file") MultipartFile files) throws IOException {
        byte[] f;
        if(!files.isEmpty()){
            f = files.getBytes();
            user.setFoto(f);
        }else{
            String s = "89504E470D0A1A0A0000000D4948445200000140000001400806000000CD90A5AA000000017352474200AECE1CE90000000467414D410000B18F0BFC6105000000097048597300000EC400000EC401952B0E1B000048FC49444154785EED9D097C14F5F9FF9F5CE4228170090402C80D022287285E452A15C48AA516B0FE44FC7BB51EAD56DBAAF5AAD7CF8A15B59E3DA0FE3CAB62F1442B5A296205E4080A721308096720F79DFF7EBE992193CDCCECCCECCCEE1CCFFBF5DAD7CE4C02D96C763FFBDC4F425308621886092089D23DC3304CE06001641826B0B00BCC4445496D231554D651793D51514D131D0E9D1FAB0BDDEA9B42F74D5456DF484742D76A1A892A1B9AC4B111D29312C42D23744B0D7D4C776A974859C989D42125813A24876E2989D43974AD476A02750BDDBAA426534EE89C61CCC002C8E852D3D844051575B4ADB4960A6A13A9A0AA81F6866EDB2B1A0C8B592C8150F6CF4CA25EE94994875BBB461A90DD8EF2325342429A207D17C334C302C81C676F653DEDAE6CA08D650D945F5A4F5B42661DC4CE2F401407B54FA611D9C974525612F5C908096546B2F4552688B0000614885D7E4935E55710AD395A27042FA84010C7744CA111994413BA66B02B1D20580003C2D6B25A5A5FDA486B8FD5D1BF0FD5BAD27D750B70A3CFEED28E467748A10939C96C25FA1816409F82E4C427076B85E07DB8BF86AA1AF8CF6C155910CFE890C016A2CF6001F411EB8FD6D097250DF46E71B5485230CE00977952D7549AD425990666B593AE325E8405D0E340F4961EA8A3D70AABD9CA8B03B00E2FEC9E4A53BAA5D0A88EA9D255C62BB0007A1059F49614D7702CCF45B0187A0F16408F8024C6E2A25A163D8F0031BCAC773A4D3BA11D27515C0C0BA08B4111F23B4535F48FC2AA4097A9789D71392934AB7B324DEA91C9C5D82E8305D085C8D6DEC2822AE90AE317E6E6A5D38C1EED3879E21258005D826CED2D2AA8E40C6E004026796E6E0A5B8571860530CEA05EEFF5C26A7A7E572567710308063E5CDD37832EC94DE3FAC238C0021827D08AF6CCAE2A5ABCAF5ABAC2041DB8C7737AA571D22486B000C618C4F716ECA8A665076BA42B0CD39A193DD3686EEF548E13C60016C01881DABD1776D7B0F0318641B7C94D27A6B1103A080BA0C3B0C5C7440B0BA173B0003A04C7F818BB816B7C5DDF748E11DA080BA0CD20ABFBC2AE4AAEE1631C03C9929B0670F98C1DB000DAC81B85D5F4D096722E67611C07E533F70F4AA3F373DB4B57182BB000DAC08A4335F4F0D60A2E6066620E0AAA6F1F94C1C3172CC202180588F33DBCB592131C4CDC41A2E4370333383E681216408B3CB7B392166CAF90CE18C61DDC37348B66E6A649674C2458004D82B2969B3796B3BBCBB816B8C5F70FCDE4B21903B0001A04C30A166CABE0EC2EE3196EEA9F4973FBA473B6580716400320C9F1EB6FCB791029E339B00BF90FC3333949A2010BA00E6CF5317E81AD417558003540ACEFE71BCA696F15C7FA187FD03F33899E1995CD9962052C802AA0A0F9AE4D65D219C3F80BCE14B7C002A8006D6CBFC82FA5552575D21586F127A81BFCFDD0F6811FC2CA02288144C78DF965DCC6C60406B4D3FD757456A013242C8021B8A8990932417689032D80C8F2DE12B2FAB8958D093A18B575D790F681CB1207560039CBCB30AD096296389002F8416139DDB2896BFB18468D174ECEA6895D8211170C5C0A08F13E163F86D1E6AA75A5A2142C0804C60244BCEFBECDE53CA2DE6132139BE8C4D446EA99DA1C4BEA95D248B9ED9A5B087B27D68AFB4EED9288AA9B934E7575AD4B8E52D333E85063E8EB21F6343637F317D626D2DEBA44DA57D34425A1AFEDE5906D4CC0E4E9DB06F97BE06A200490EBFB9C4116BBF1ED9B84C841E07AA4A8BF9CF032ABA8A8A0EAEA6A2A0FDD37D4D74B5F694B5A5A1AA5A6A652565696B80FA7AEA15188E497D5694218BFA90A09248BA223A05E70FE88D0DFC1A7C911DF0B208696CE5B5BCAC90E9B1891DE20046F425AB5A6D885535E5E4E870E1FD6153D2D3A74E8401D723A514A927EB4A6262199D65727D17F2B9259106D06C991BF8FE9E8CBA2695F0B2076F1CE5BCBC5CDD102D19BD1A9814627574514222535353574E8D02161F5454B972E5D84181AA5A82E4158884B4B93590C6DA05348FCFE363ACB7733067D2B80E8EC403097B146AF90E73925BB9EA666D7516A9379CB2D1AAB4F0BB8C6DDBAF73025C2E0AB9A546119FEA734812A1A791A4A34BC3236DB579D23BE1440163FEBC8D6DEF854EB6613ACBE63C78E4967F692949C4C3DBA77578D0D4642B60A5F3D9CC44218057E2A93F19D00728D9F35EC103EE0A4F8C944238200F1C2F74B535808A3C02F22E82B01E43156E681AB3BAF4B6DD4C28797D1E190CBEBB4F8C9442B820016E11B6519B4F468E0CA616D61FED074CFEF25F68D00B2F899674AC746BABA738DA5185F38B1B0FCC2B14304016284F38B52D81AB480D70729F8420059FCCC81FABD5B7AD4456DF5C940F82080F1002298DBABB7E9C44838708B9F3F9CCAD6A005BC2C829E1740163F73C0E5BDBB5BB9E11ABE4820DBBB7FFF7EE92C3E203BDCB3674F4A4888DE825B5C964E7F39C823E3CDE25577D8D302C8090F7320D1714FCF5A5B5C5E803ABFA2E2625B4B5DAC821A41D40A460BDE0EAB6AD3E8BE42DEA96B162F26463C6BEFA3D485C5CF3810BFFB42969F5DE207A180DBEB06F10370C3618D460BAC488406EECA6DEE5B668C83D233BC2FBD84270590EBFCCC01B717965FB4713225C8F8DAD1E1612770C56195DA0144F0CAAEEE10772F81F7253AB0BC82E704104F2E8B9F7190F040CCCF2ECB0FC0D28A75C6D728B04AED8AEACCC8AA129972C61CB357978A81C35EC05302D83CD880131E6640B6D7AE840710935842D69F5B81550AEBD42EAEED50262C68C61CB3422288F7ABDBF18C0062A4D5ACD5C778B0810910F7B3ABD445E658C911D7C4FDB480756A972B8CB0012C68C61C789F620A13DEB76EC613028861A6FFB3E6281D71F993E9366EEC626F92C8CDAE6F3876BAC2B0A0D915360F46D05DBB2EF461147AFFBA154F082036B76DAFE0797E66C01BD64ED757647D5DECFA860357B8B4D4BE58F1CCAC4AE98831437E69BD98C4EE565C2F808F6C29E7B59516B0FB0D8BB89ADB5DDF70600522666907F830414881310FD65060178F1B71B500A2CB636101D7FA9905417B3BAD3FC4D3BCE2FA8673A0B8483A8A1E4CCB61ACB1607B85685C701BAE154094BB708B9B3530C8D44EE2D5E76B076207890D05D20013B15156C458038D0B6E2B8F71A5002273C4E52ED691B7B0D901C4C36D05CF6641ECD28E840832C25802C558E78AD0FBDA4D9961D709203246C81C71B98B7546A5D9E3AA792DF1A1056297762544E4759F8C3550C9810D8D6EC17502B8605B85C81C31D6808B6657D78717131F5A941C3D6A4B42047B8E99E8C07A5AB724455C2580089272D2233AEC72D1BC9CF85003428E22EE68B133BC1064901471C3E004D70820DA6678BA4BF4D8E5A29595F92F066B47870896BF33F670637EFCE381AE1040C4FDAE5BCF030EECC00E17CD6FD69F926833DA282F6AA8E0D7AA1D20CE1FEF78A02B0410713FEEF4B0073B5C342F97BD44C28EB2989EE5C52C823611EF7860DC051071008EFBD947B42E9A1FCA5E22116D594CD78C76547F9845D02E100F8CD70CC1B88EC487FF3F79C5112E79B19137FB5759CE02E3A5B0BBA0C0D6CC2F96168114E91EA86D714B4949918E5AA8ABAB938E5AA38CE3D5851EAB95C78BF1F918A36F85677656D05BBB9BC52FB973774ACACC16C78C753AB54BA44FCEE844A989B12D338AAB005EBFBE94FB7C6D042530AFF5B5EEDEC1F53513FB83B841D86441838825252589FBC4E4145B275047022FE3DADA66EB17C2D9D0D020EE65B10CB76AA3D926B7747F353DBAA9443A6311B48B193DD3E8816159D2596C889B00F24223FB41B3FE433DACC553502357B06BA774D61AA5D061031B04AE5DBB76627F8697C0EF585355795C1CF1BBB46F6F7E93597EC85DBB795DEB921A16417B88F562A5B80820BBBECE8011583774AA90CECC215B7FB2D8411860CDA5A667C4D492F302457509F43F2BF649672DB4EBD1971252789B5C34C4DA158ECB2BFBD16D152C7E0E60B504069F81B0EA7AF5EA457DFBF4A1DCDC5C111F8308B2F8B5456BD24E6DD12E6AAAE33AC16840AB1CAA426245CC2D40DEE8E61C58E568F7087CA3E06524C7E0809CC080BB09B4121A7AC8891158A2403E0788312687AC8478B9E157AE2CA2028DA79A2DC1E879656C368DEAE8BC2B1C530144C1F3B9FF39C2A3ED1DE285DEE5B6CE01044A61432241163239B960350B6B17CA2CB35A32C6A958E56FD61FA63525DAD61E8B6074F44A4FA2774ECB71DC158EA90062BA33D7FC39C7E23EC72CBBAC481034D6D71D1739089C13E286FF1B3759546B1456A392D4907041BC20624ACBCF0A725C13D895C85196C268C122181D37F5CFA46BFA654867CE10330144A123F68532CE60A60446CE8642ECA215BAA3478F8ABE61FC3FB8C7ADA2A2429CCB37881D6ED1746040AC1093C47D76763665666652565696B8D6B55B37EA949363492821861045FC5B1C1B15C5F052182D5804A3E39FA776A08159CE3D7F3113C09F7C55C263AE1C44AB04067F5E880FC40E026456EC60AD1D2929A183070E887F5F123AC66C3D8CCA8AB6A5CC6E20869D3B77A61E3D7A50A74E9D4452A763C78ED2578D238BA2B8D7C882AB95C268C122689D713929B4688CF9BFA151622280D8EDC1E3ED9D45590203ABCB8AE0C19A4339CCBE7DFBA8A8A8C8952267168862CF9E3DA94F9F3E9497972704D22C4A4184E5090B51AB14460B1641EBCC1F9A4EE7E79AAFD73482E302C8357FB1E186CC833426A99CCA43EEA711C18365575C5C4C3B77EE1462879B1C97F33310C4810307D2902143A877EFDED255734008F1FF5CB1A192CA4CCCF06011B48693B5818E0B20273E9C632095D3A084729A482594D918B9FC65CF9E3D42F076EDDA25C42FE840C44E3AE9241A3E7CB825CB106CA84AA482BA24FA77798A21316411B486530911470510434ECFFB2272A098310E921DE734EDA791F547A8BB81C92FDBB66DA3AD5BB7D277DF7D17080BCF2A7091C78C194303060C90AE980762F86E599A667DA00C8BA035569CD5997242D6A09D382A803CECC03E60ED9D4B07696853E4610588DDAD5BB78EF2F3F359F44CD2BD7B773AFDF4D3A312C2E2C676B4BABC49D72A6411348F13C3121C13402E7BB10708DFCC860243D61E5CDC2FBEF88276EFDE2D5D61AC028B70F2E4C9965D6399774B5334859045D03C7697C53826805CF6121D66846FFF8103B4F4C30F7D1DD743590B66F8E11E37F42AA30E50AE0794BB4064E44C389E9B7D8585C21AB6F2FC9C75D6593461C204E9CC3A5A42989A37483A628C30A96B2A3D35CABEA93B8E0820F7FB5AC78CAB8B4CEE679F7D466BD7AE95AE781F2426FAF5EB2732B4A8E7C36006085FB8C0590122F8F2CB2FD39123E6B6C3C11A9C3E7D3A6564441784C7DF6B695506BD7B4CD1D39C9145C91D3AB32568023BFB841D11C0E92B8FF08E0F0B4C4B28A6F31A8D5929A8D97BE38D374CBF99DD04BA2EFAF6ED2B0406A287B89BD529CD468165B868D1225AB3668D74C518B03A67CE9C69A9B03A1CC408FF7A28F978B2042298D2A547F309139111D9C9F4DAF81CE92C3A6C17401E746A1E33EE2EA8ACACA4850B177AB24879D0A041A2F40419D7112346D0FEFDFBA9B131B6C331F0925FB26409BDFFFEFBD215634004E7CC9913B5252803B758B6065904CD61D7E054DB0590AD3F7340FCAE6FDA269D19E3B5D75EF34CA203561E84EEB4D34E13D9D5AE5DBB4A5F69063589B1164019840F5E79E515E9CC18C812CF9E3D3BEA010D32289D79B1244DC40659048D63971568AB00B2F5670E332EAF0CEAFADE7AEB2DE9CCBD40F49045FDDEF7BE47E9E9E9D2D5B6C45300C1D2A54B4D3F9FA3478FA6EF7FFFFBD259F4C0259E5F9CCC2268123BAC405BAB0A9F2EE09A33A358113F80A266B7021711D611120D8F3DF6184D9D3A5557FCDCC094295344A6D70C483AA1E4C82E10FAB8A57B3D65251135569651DDA122E92B8C1ECFEF8EDED8B24D0091F965D7D718707BAD881F402B9BDB405CEFB7B7DF4EFF1712BE79F3E6B57173DDCE25B3668B448C19DE79E71D91D5B50B1641F360A97AB4FB846D13403BD438085889F9C9A0A6CD4D890FB8B90F3CF000FDE94F7FA249215737451A5DEF3530EEEAEAABAF16F14AA3E0EFB071E346E9CC1E208297E534AFEF641134C60BBB5D20805061A8311319647BADB273C70EE928BE201170D75D77093777FCF8F1D2556F835AC3D973E64867C658B972A5AD56201899DE487952588B45303268B5C5CC01ABD82280AFEFE3D89F1160FD192D755123DE995F5848575E7925FD75E1423AF3CC33A5ABFEE1B40913843B6F14588118326137F3BAB4BCA1590423F3F2DED64BEFCD10B50062DEDFE27DD61F4090408787556069C45300E1EE3EFFFCF3346BD62CCFBABA91C0A053FC7E66F8E69B6FA423FBC087A46C050216417D306E0F3A6485A805F0F542163FA318696FD3225EE207ABEFFAEBAF17EE2EDAD2FC0E7E4714691B057F1714A6DBCDC8B4D6AE358BA03E5675282A01C49ACBE777D9FFC7F723707FA30163EA630D32A34870FCF0873F94AE048369D3A64947C6D8E1406C362FA56D45058BA0362FEEB196848D4A00971555F0A8FB188191F5B104357CCF3CF79CE8D50D1AB002CDC40263F9B761115407BBC6518A6796A804706121677E6345ACDE6470796FBBED36FAE52F7FE9DB589F11CC247962FDE1C422A8CE2B853114C0AD65B53CEFCF04FB1233A523F320C6148BC9CE1845F5E8A38FDADAE6E555468D1A65B82ED089DA4CEC19D18345B02D564A622C0BE0E2222E7D3143456382E8F9B442590C8A9F51DBF7ECB3CFD2D0A143A52BC106F3078DBAFF4E086091810F4C16C1B6BCB7DF9C2E591240243F5EE3ECAF69362477928EDC05921D0B162CA0134E3841BAC200337B41EC2C88AE484CA53525C6DEC82C82AD319B0CB12480AB8FD472F2C3029F259C205EDC66C90AB9A64E01F17BE49147C42003A635BD7AF5928E8C817DC176F0E95173356D2C822D984D865812402BC146A6D90D5E41E667986100275C54BB81E83DF4D0432C7E1A9879CE31D11AD963886634428830897264BE5158045B78FF807137D8F43C40545C4FFCFCB074C658E15ADA69BA281A8990A79E7A4A3A8B1E04F81F7B7C010D1E38408CD53F78F8081D2B3942E51515D4505F2F46EED7D4D6526D4D0DB54B4DA5544542008B88D03BDBAD5B37E1364733F22A9A7980186F5F545C4C870F1DA2B2B232712E838548704BB130096465678BDF01BF37041FA3F791F4D1E3D8B16322236E84E79E7B4E3A6A7E5C7BF7EE95CECCF1E0818C887B85F5E07982CDAC9DD485521313A4336D4C0BE01B85D574D7A632E98CB102969BDF58B7C9705F30DEAC8847619785D931EEE120608F3728D63DE2F8E0C183510F248508E2F121693078C8101A3E6C180D09DD1B114623028897280AC1310B71CB962DA2FF161D1810E968484C4C14A3BBF2F2F2442860DCB87174CA29A7889638702824AC77DC718738D60396E2BDF7DE2B9D35837F0B0135C30BE51D0DC7FEF46011249A3F349DCECF8D1C3A322D8097AF39CA935F6CC08C08E6F5ED475D3B37BBA9EF7FF001BDF2F2CB96CA62304B504F6CB0896DE0C081A20818A2901DB29A6041418031025EB6AA20A0B01A214A78A3438C204ECA21A11017B885F20E10DC860F1FDEC6DD0E174035B1FB6EDB76AAAE68CEB4CAFF2F040B5BE3F0F8608DE21ED61D1E276E789CA5A5A5C2728610E1B11516168AFF574F38274D9A44B7DF7EBB38362A80E89346BBA0127CB860DF895194FB41EC20B973774ACAB46F7DA4D730BA3ED39400B2FB6B2F10C1CB1A7745748787852C2AA53585B1F888DD9929BF80606A4D3186E573DFFD0F0877381A208ACB972FA78F3EFA883EF9E413559186B50821848021660691C1BF9385148F31FCDF6113DB39E79C23F68A4048A359918997FBAA55AB44E2474D08F1B3B06D0F4030EFBBEF3E71ACC7C5175F2C264B2B31E306DB65F98513741134E2069B1240767F9D21D2787CB5E6FC75EBD7D3430F3E289D45464B0061F57DF8E187B68FAE876B8DBA42B8ED565DECB4CCF674D5BC2BE8073FF8812D7B81956CDFBE9DAEB9E61AE9AC05FCCC77FFF9B638DE15126423CF31A661F70D09BA12BCAD22F50887AFC77482208BA01137D85416F89D62AEFD7382F79ABAD3530903544B64929293A5A3D69C3C6A94A9A9255A5C75F5D58EECED406CED77BFFB9DD80F62B4A342098479E15FFE2C0631D82D7EA07FFFFE3471E244E9AC85AE9D5AB2F4D555916BCAE0D2F7C9CB93CE5A401C51EB6F07B00D0E8B909C143F507FB8981A2A4AA5B360F1DEA1C81FBC860510EE2FC7FE9C632BB5A7071286D04789C64B2FE07A19052284373C62684ABE17722D9D0413A3EF0C09A119F018EFBEE71E11DB7312ACE954222CCED007824C45458574A40D3E84E4A4891160F521D3FBF4A1E65598B120A82288D638346DE8615800BF3CC863AF9C067582B235B829A18374551B645ECD4C2D41B7075640CA1619E25DB198F1F7A39050435C8C02510977299D40D9E9018BF0D597FE8F4E3FED34E90A89D29A48202E690458F74874DC53E8BCD5A7465045104D1B7A1816C0FF1C33952C66A200D6E0B3D44F08E1C606FD9E5024078C005181BB3672E448FAF18F7F2CAEA1142616C0C51E3CA0BF74161933A21E0DC86ECB609D67785DA0B2AE500D94BFE87D80A09EF2B8F0ED4DB235CB6B85208AE08A23FA5EAB6101FC707F1C3EB6028E2C847A7DA670E38CC4D894968A7C6C25366715E5CF822B8EC2E18F3FFE98FEFC97BFD0ADB7DE2A627E3272F1B2D3283B36C68E1D2B1DB580B21F3DC25D6825750D8DAD842F56EE6E248226824B8AF575CB900062EB1BF7FEC68F6F74DC61585728DE8D84F20D8E514FB1462E6DB9E4924BE8C5175F1423B7E0769ED8AF9F2821514EA231E27ADA414343B32AA13447AD2B245299915E126A73599DAB844F49904410BDC118DDA7852101FCB2C4857FC50071E0B07EEDE559679D251DA98337B7D255C331E27FA8BF8B057521A1418D1F7EE6DD77DF2D5D6D0D32BDB7FCEA57E218C5D1B1401638D425AAA156C72883E267BD24CDBE1A771B0C4112C1F5A5DAD9604302886C0A133FFE5BA15D4E0110D7D3EB6B45E74438E8F828292911E2E434DBB66C1145C7D8B8A6577283C4078AB2B169CD4479AA65E40F001465ABA1177A38FBECB3A523757654BADF68088A087E76280A0B1069649EFC1C5FBEA9D2FF33A1F54B2F1BA98CAFC920D1000BA72006D6160AADC10F67442EDB813B0CB17462DF6E3872A172BF134F14F7E1685980104C74A4E8B1BAD81BC2120411D42B8789288091D2C88CF3EC0D19E02555FA7F07BD31F66A73ED30B4006CDCB851DC3BC9DB6FBF2D44D848AB1D6295A8037CEFBDF7A42BCE819642A056C80C30F5468DE9D3A7EBD6FE15D525C4A5D4C52A4110C1CDA5EAEF9F8802B8D18D51DC00F2F6217D97105609E2526AA8B97823A5EF5DB16285B8770A647AD1823779F264E98A3E70E5915C402FB1D9692A66F9FAEBAF457D62CF9E3DA52BAD51CB92E3B1693DCF326FEFB57F44BED3F85D04B5F2181105F00BB6005DC1D252FD382038FFFCF3A5A3D6A809E0D0E1C3C59B1FC30B9C8A03E2FF7DFCF1C7C5F1CC9933C5BD11E006C3FD7CE59557A42BF6833E5F4C6B19316CA8A635175EE387B0C1E5975F2E9D69E315F7371C3F8BA056182FA20072FB9B3B801BBCAE3E433A5347CD3A41F1B3DAAE0FACBCFCDE59670A1158FEF9E7D2557B79EDD55769D3A64D22B16166D9D2C433CF128F195D2B102A2778F79D77C4FD840913C4BD1A88AB22C33E7AF46851287DE32F7E19B12F39FF688DA7DCDF7020824D75FE337A566A1872BA0288FA3FC63D3CB735F20050CCA5536684F5DEE0175D7491B87FEED967C5BD9D6094D4830FFFAF38FECD6F7E23EE8D92929448575D7595982233FFD1474551B19DA0FC058365E1E2EA75D240EC2EBDF452BAF6DA6BC5F7E17145E2A5DDDE737FC3A92DDAE53B11441DB3DACA4CDDBFE8D60A2E7E7613F95549F4D17EFD092518128AD1F9B004D1AA3567CE1CE92B6D3967D2246199613EDE3FFEF10FE96AF45455550921C610D32BAEB84258506681E0C0728405F9DC334F4B57EDE189279E102EF685175ED8AA1D2E5A96EEAF7664AE5F3CF0A3087E59D2560075E7015EBFBE946B005D0686A8BE3AB89172D2D5DBD8B230BD39E4DE1A05023363C60CAAAFAF174356E53E61AB20EE77DD35D7D0B265CB44C7C9EB6FBCA1FB78F446E22309F2B39FFD4CB8E910525863D1004BF289C7FF481F7CF081C84A3FF9E493BAF5936640DFF0ECAF8EB8B2F3231ADAF5E84B0929B16B997492193DD3E88161ADDB2C752DC075C738FEE7363031E6F65D2D6D5CE198113F000B1042909C9C4CBFFEF5AFE9E73FFFB9705FAD80C2E29F862C4E881FFEDFBFFCE52FA61F8F1258678F3CF2888807FEED6F7F13ED7256DDE1FCFC7CBAFE67D709F1C3FF77FFFDF7DB267E784C776F2EF79DF8013F59826AF90C4D0B90C7DFBB9B11E90DF4605F6A65099AB5FE94C012FCD5AF7E25EE518707F7F082E9D3E9B40913220E4CC5F4678C917FE18517441133628B0F3CF080A141AB469622615C3EACD3F5EBD70BCB0D9958242822252460417EF9E59762443FFE2DC020869B6FBED936D717357F0BBE3DE41BD7570BBF5882E163F2350510CB85AF5AE7EFE248AF0377F88CEC269A9ED78126758B7E2937DCD7F7DF7D97162E5C785C30208683070F1637C414E5492D1858505C5C2C3A36209A00561FFA79277DEF7BE2DC08460410E0650A21FBFBDFFF2E5C622430F0F350C3874C371E97BC1AB3A8A8880A0A0A8EAF00C0F79E71C61962802CB6D5D9812C7C5B4A6B7D69F9A9E107117C656C368DEAD8F2C1A92980CFEDACA405DB234FC465E2CF948E8DF4C7B16D4B5DA2012203EB69C3860D623B1B0405D794ED6170253154140917ECED404FB2598C0AA00C5EAE28605EB972A5105F889D72B9116A1B31D61E5BEDB0A613830E108BB47BACFE333B2BE8ADDDC13310BC2E82F70DCDA299B92DC682A600DEF16D192DDEC73B40BC002CC12FCEEE1C55BCCD28B012EB432268C4BD35825901D402969FDD22A7C7C5CB8B0263F985E365110C4F84682641367002C4332031B2FC706CFE5E1059BBC4CF4E62297E707F83DC21EAE5C4C8B6F2D6A5309A02B8BD22C07F610FF24E81B37DB34C0B1B8E44DE16E777BC2A82E12D71AA02A85631CDB89BFF942608F794719EE7B6944847C1C6AB22880A17195501DCED81618E4C6B62E9060799A0BBBFE1D41F3BEC39112CA86C799FA80A6091CBC77933EA18E91566A2C38BA3AE9CA4B1B2CC7396A0B2C55755007754B00BEC45D02B5C54137D4695D12688A52F46F092257838920B5C50C56F22AFF2F2E6FDD21163371875C5A8E3254BB0A0AA2586A11103640BD0ABBC7A388993210EF1F8A6D86CD1F3325EB00495A530AA02C82530DE05C99037B7144B678C5D786DCF47BC80250811743385D52D1E6E9B4E101E82E07D7AA5127D746657E92C366006207A7557AF5E2DDAD3407676B6E81FC606350C6645CF6E386A9D201858BA213F9F76EED821FA8D4B4B9BE36EF8FFE4FFCBCE397E46F8CDFAC3BE1F786037A97983A423F7210F45682380D8A2FEC3FF7251ADD7796A64962D03128CB0ECD34FE9C9279E38BE685C0B6CAEBBE4924B448FAE8C520031BDE5DD77DF153DC85A2B2901861BFCE8473FD29DE66C27B0FEFE67C53EE98C314A624616A574E9219DB98B8F4ECFA15E19C96D0590A7C0F883585981AFBEFAAA98FB671488D765975D2696A4035900BF58B9925E79F9655DE10B07FB3A30F15A6F45A51DB0F5671DB78AA03C15A64D0C906B00FD0196282D3BE0EC308B7FFEF39FA6C40F40E0F06F7EFFFBDF1F4FD66096E0A2850B4D891FF8FCF3CFE9CD37DF94CE9C01D61F8B9F751013AC3BD41C127113FB2A9A8BA1DB08A0B24686F1360F7F177AF13994115EBB76ADD83D621588D75321B719139AB13BD82AF8B7B01E9D0233FF98E870A3085650F39AD9360278AC8E05D02FC00A7422238CB980F7DD779F74661D6C66C3EACB6881EBECC4FA4CB6FEECC36D22281B7A6D05B09E5D603F31BF28C5D6EE10647B217E91121EB104AE33567B2289621798847DE76A4E7CD8899B445036F4542C4016403F81BAC047F20F4A67DA60A1D1F2E5CBA53375207EF7DE7BAF9810ED36F0F81F7BECB188C2BC79F366434B9F3E28AAE4BA3F07708B08CA865E1B013C58C345D07E63E9D1C4880911D4E82D5EBC582C0C425C0D82A204A3F1B13469CD9A35D295E8C1CFECD3A78F74163DA819C432266C805316374014F1B811B35CB46891D823A2474D42323DBA89475E39851B445036F4DA94C19CB7E208ED55F4CA31FE006531EF9DDE49776C3E961BDD78E38DD25973C90A5647C2C574C2E5BDEBAEBBA80EFB881F7C50BA621FF263C7E3566697AFBCF24A1A3F7EBC74A60E97BDC4867896C88CC84EA6D7C6E7B4B5002B1BD805F62348883CB1F18074A60EB6AC4D9D3A553A6B8EADC1127442FCF073CE3CF34C3AB15F3FB1ADCD6EE4C7AE143F2C6F1A376E9C74A60E061EB0F8C586785A82259205D84600AB58007DCB5F0E26477485AF0F5980A3478F96CE9C01AD6CF8393253A64C115D224E8296BCB973E7EA164DC3F5BD791D0F3C8825F11241D9D063010C18916A03E12223D101917202587B77DD734F1B577CE6CC998E58820071C65B6FBD55B8C47ADCBD8E4789C5837888A0AC736D6280C3FE153963C8781BA37B84D1E6F6E28B2FB67223AD020BEC861B6E68137F0B1F86807ABE975F7A8976DB54D707CBF287332E0E096E9BCFFA562CDD5FCD898F3813EB98E0B793BBB2000695BB726B69D6D05CE94C1B143DBFFCF2CBF4AF7FFDCB9210C2FA9A3E7D3A4DBDE002D5048CDA3418BC2457AD5A257EA61521440204F1BE69D3A6516E6EE4DF91871DB887588A601B01AC696CA2D1CBB8F52728989918831AC0955F7E49EBD7ADA36FBEF9468CBC521344880FA6BD8C193386C68E1D4B23478E94BEA28E9A002A41CD1E466C6DDBB64D7CAF9608A3A466D0A0413478C8101A1912BF48EEAE0CE27E177CBA473A63DC40AC44B08D00F22CC0609199D8444B2676A11EA9FAEEA116070F1EA4B2B232AAA9A9A1C4E4146A9F914EDD42AEAE5EA94D38910450095EAA870F1F163FAFBABA9AD2D2D284D065B40FBD6122B8B86AA0DBE38A15855CF0EC426221822C808CA80F5C34BEB365118C163302682710BFDBD61EE4921717E3B4084200E3F3AA675C03EA037FB1FA40A0F68840FCFEB4BD8CC5CFE5C4223BDC4A0073DAB11E0611ACD3FCE99707032382103F5E6FE90D20820D15CEFDAD58F118415044F0999D152C7E1EA3FE70B16322C802C81C4716413F2E5787DBCBE2E75D9C12411640A61510C1CBBF3AEC2B1194131E2C7EDEC60911640164DA80C4885F4410757E2875E184873FB04B04D3939A7BC2DB0860274E8430212082E72E3FECF86225274187C7ECCFF7709D9FCFB0430435059061945CBFA18C7EB97ABFE79223E8ED457B5B5970AA7B0245B42298A12580F21718460613A5A77D71C413D6205C5E0C34E5C106FE271A11CC49D11040F90B0CA3042E31ACC1F9EB8B5C690D22D18161A6E8EBE5785F70B02A825D539BDB35DB08A0FC058651E3ABF2045AFEF9E786160BC50A88DF9E3D7BE8F14D3CCC34885811C10E5A16A0FC0586D1A2A1BE9EBEFDF65BB1452E9E4208E13B74E8106DDDBA550C4760828B5911EC90AC2580D217182612101D590831D42016AE31440F4078217C76EE0266BC8D1911EC90D2FC3A52B100DB5C62185D208410A3CF962D13EB333144D54E3184E8E186E54C3B76EEA4EDDBB7B7B1F83A74E84025F5D20913588C8A6067A9DCAF8DDAC95F60182B40FC208210C3AFBEFA4A8815E60662A0AA5164C1C3A4365878103D082CFE6FB8DF4A207CC3860DA3010306485798A003116CAAD34F846552F3EBA8CD48FC15876AE8AA75E6B32A4C301891DE40FFAF325F3A3347527232A5846EA9A9A994929242494949E2BEAEAE8E1A421623EECB2B2ADA889C1A103E8CBB4F4F4F97AE104D7A6713D7FD31C749EEDC9D9232B3A5B3D6BC32369B46754C6D6B01764BE51820E30C1036B8AEB0EA90BC8045B777EF5E718F735C8F247E4A8B4F297E0C138E9E25D8B99D46194C97D464E98861DC030B1F6385DAA25DAA22D8354D430079282AE32658F89868091741CC3B484DD4288301FD33B9189A892F5DBA7461E1636C432982B9692DB2A72A807D32D80D66E2832C7CD827CCC2C7D8892C8203DAB7E89BAA00E6A5B31BCCC416081F7608472B7C89059B2961D547441F2C247AF181E65BE818D792CB794042D08108E6A5B778B86DCA60C01B85D574D7A632E98CF13BD8BCD5F4EF37A969F32A6ADABF87A8BAA2B90EAFF7A09032E552E2F009947CEA0F2821A55D5465306A40F87AF6EC29CA61A265FC1D0BA871E98BD2990A69999478F6C5D434EE3CE90213449E9A328ACECF6D5E9CAF2A805C0B181C6ADF7C8AE8E39722EFE695C463F88FE6D2F54DDBA48BD6403D6097CE9DE984134EB045F8C0279F7C42BFFDED6F0DED184E9C72198B608079EBE2B1A2061068C400390912046A9EBB5D584C86169387AC427CEFC6077E4E478F1E952E9A03C207D11B3E6C18F5EAD5CB16F14301F59FFFFC67C3E22708093EBBC3C1252FA3E575A72A80BD3809E27BEAFEB3849AD67C229D19A769F7667AE8A187C4F829A338217C60DBB66D3477EE5C7AF6D9678D8B5F087C6FFDF27F4A674CD05096FAA9BAC060FACA23B4BD82FB8AFC08326135B7FC40587556418C70CA9429346DDA344D4173C2D50510BE458B16D1071F7C205D318F8871DEBE483A6382C2E86E59F4C60523A5330D0B108CEC60DF0B967117F5FFFD302AF103B0A2204077DE79277DFEF9E7A28F5746B6F8469C74926D161FFE7FC4F9AEBBEE3A9A356B5654E207F0F89131668245DFECD615069A16E0733B2B69C1F6E8DE248C3B41ECCF8AFBAB47C78E1DE9B4D34EA3F3CE3B8F264C98608BE8959494D0AA55ABC4BCC14F3F5F1ED2EC72E92BF6C0C990E0A1CC00034D01E44CB07FA979E07211CB730A590CD1C53178F060EAD7AF1F75EAD4495314312AEBC08103545050403B76EC102EEEC68D1B4DC519AD9030E65CA2F3E74A674C1050668081A60096D436D2C4CF0F4B678C9F705A00B548CB6C4F1DDA674A67CDC0CAABADD59FDDE614097D86105D768774D60CDCE2A6FD05D474689F7425F47D5D7A52C20979D49817FA7EC6D37C3BF7F4E37DC0405300C1984F0F515583E6971917834447DD92E7A9DD7F161F771D214035434EA5A66FBE8C3A06E807640184E835869E9348CF0BBE3F79C6CFA8BE7D8E7485F1129DD352E8AB39E3A5B3667405F0FAF5A5B4EC20AFD5F7222870D6ED8A60447177C209BDCD59C3A17F9372ED432C821E64C6806EF4E85903A5B366749B7ECFE9D24E3A62BC84D889F0F14BD2993EEDDA05EF6F8CDF19596A587BA64301A17FC33584DEE4DCFE3DA4A31674057060264F87F624BB37192E0CAEAFAF176280BAB82080DFB577EFDE620AB55584ABCC788E113969D2510BBAAF7A65B684F127104A2C2D42B6163142BF02AB6FD4A851D4BE7D7BB1A8292A425620D7107A0FB50EB7881FFBE372B820DAEF4004376DDA448307F4A7FEFDFB4B57FD032CBE73CF3D978A8B8BA3173FC69320FEA74644013CBD13C701DD0CB2BD0DDFFE57F4F622F18122E7FAC54F4B5F35C7FAF5EBC5FDA44993442D9FD781BB8BDF65E0C081A2903A1AB797F13679596DDD5FA09B05065C10ED3E207A68676BFCF79B94B0678BE1789F51E442666C6A8328C6AB4ECF2A103E1461F7E8D143EC13CECFCFB7FD394AF9C5139C09F610E105D0321105B0A6B189462F3B249D31F106965EC3EB8F3B5EC78798D9B871E3A86BD7AEB473E74EE122BB5D08217CC3870F174356CBCACA68E5CA95964777E921EA297FF98C74C67881EDF3264A47AD892880E0275F95507E69E465D58CB3C4A3B60FF1B33163C6507272B2B0A676EFDEED88A8580562D42FAF37F5EDDB97B2B2B284487FF7DD77E266B7D527C32D74DE227C028C124302C88311E28FB0FCFEFE8074165B600D0E1D3A54C4D2502E03D71862585858E898C8E881C70361EEDEBDBB7073E5121E58AA4EBBECF85949373ECEEEAF87B869741EDD38BAB774D61A4302B8FE680DCD5ECD71C07861657E1FDC41BB83FE880DC2C5CCCDCD15E710BFA2A222915D2D2CDE1F7A78F64E6B9181E8C015C74005081E5C5C193C0658A5F9DF6E72ECE72B81F8D626A6880E129030641CF709BB9C0F7F3C8E0666A927730D0920E0BEE0F861D4FA8350C816192C3658424E947DC842A8B4BE00E26EB00E8F1C3942E5E5E574ACBCC2B428416072727244BD1E6E9D3B7716C2A7FC3900BF1B2CBEEFB66D8F89F001F9B1A97EB0F0C22557A2D6FFABC4B000DEF16D192DDE572D9D31B1C4C8FC3E14F9CA652C002EE2A9A79E4AFFFAD7BF1C8BD985C7DFD48020575454504D4D8DB801A58B0A51494D4D15B7CCCC908884099D12D9E2C4D8AC58BBDF785CC88C633EA1AE8B1D12C2A44B7EC116A14B50EBFF556258003F282CA75B365549674C2CA9BE7192AEFB2B97AD28A72443582EBCF042213E98A4EC645C0CE03160A72F565C6A89A115F0B8217670B3617939FD7B68818C387EB6F243460F1EB6EA0EFE7EE1589AD845BBA3CDB000F27CC0F8809DBD0DB75F249DA903EB0FAEE2B265CBA42BCDE04D8B61A4704B3FFBECB398594CB2AB08D715B7ECEC6C61E1E1BA1610175888A5A5A5C27D861B7DF04849CCDC5B2D64CB0F31C8F7DF7FDF940027FDCF1D6C09C699F0F97FE118164070F99AA3B4AAA465F703E33CA2CBE3F11BA53375CE3FFF7C211EE1020817F507DF9F2C84075614EAE262E93686033141394D624A8B1036A2A8BBBE3EAE8F4B0B3C6F679C718648BAAC59B346C4536571379460C2B8AD5F3D2B9D30B12692FB0B22B6C22999DE5DBD9D84718EC623FA6F34880A62676AC07A92450F995B58327A3136A7C1E3800585C725DF70EE46F143167DEAD4A942FC906C81F8C1CD8720628AB5217868425C511B7F158EA977C3B95DB92FD86DC0BD84A8C1C55403960A960A4168DC20825E0019F433CF3CF3B8E50CEB0F823879F264FAE69B6F4CB9C19834CDC487493DD40D0325A6DE095828CCD361DC852C7C5A020820821F7EFC2F61C9A074E59C73CED18DC705155878189E3062C408F12121870DF021830F0ED41B1A727D99B803F7572FF62763DA14603738B64C2FFD463A52C7A890C1DD4409C792254BC41B1965322C82CD40EC60F5C1C283CB0B971C031456AC5821BE0EF1034633C04CFC31E2FE02D302C86E70EC78306193667C2F1C889911D716EE1BE259B85D74D145C2B50B32F8FDA74C9972DCEA43C61CB59318FE00D0078DB21EF4169B717D65E68ECC938E985862C4FD05A605106EF0A4AEDAEE16630FBF6DF89646F6EB259D69A3B4E2E0AA99019D1B4F3FFDB428A3091AC8904F9C3891CE3EFB6C217010BE7FFFFBDF22932E178EC34A461911840F026805841BE6F76990CE985860D4FD05A60510CCCE650174926B69274D1CA8DEBC1D8ED22AD18B03AAB165CB16EAD0A1033DFAE8A374E9A59706263902AB0FD3AF516F8818DFDB6FBF2D844F19DFC3070BAC3F60759E203E589078C207D9CFBA701755ACB8CC84D56DE9153FB6533B4A4FE285494E7052D92E9AD6AFB374663CC607D03B6B062445503F98909040575C71053DF1C413C2EAF12B18F77FE79D778A3216C4F370DBB3678FAA6B8B98209E7B58C9789EAC3067CE1CE92864959CD48F2EE8C035B44E83DE5F33BB8C2C0920CCCB9FE47232C46E32139BE8CEFEA9429064225975CA37AF59018455A37C730F1932849E7DF659BAE4924B7C650D42D4217CF8DDDA859ECF48B13C648331FA0BC04AB662FDA10B47B62065AE1D7602E5B1F3E4283F1D6A2CF92163F9553EA3072743ECE68EA6CD6D442C525FAD3C6000981540B071E346E9A81908EED5575F4D7FFBDBDF448CCCCBC08ABBEFF7BFA7BFFEF5AF2216870F96955F7C217D551B4CBAC1070084D2AAF577CDB5D74A472DE0B9BD2FCF7D45DF7EE2B2E1CDA3DA8C625900315F6B4476DB35738C35A62514AB263D225980959595D291F924088085A3066257F7DE7B2FFDF18F7F14D68C5780DB0A0B76D1A245F4E4934FD2E9A79DD6CAA20E17FC7060FDC9F30EAD4E95466B62DF3E7DA4B3D6E0FFE678A03360F23392B46688CACF999BCB45D176D02BA471F37AAA7F986464644847EAC04A915DBA48E3A4D44067831E280F79EAA9A7E8CD37DF146F6CB7BAC610E9071F7C90D6AE5D4B0F3FFCB070E7C33976EC9888F9E901EB0FE039B5324B11027CF9E5974B67EA201E3826873D28BBF9E584C1D29171A27A35A3D6869321D1F3CC890D9AD69B11AB0E135400C4C9AC1588CC27842112A3478FA63FFDE94F226B7AEBADB7C67D7F307E57881E627B68F57BEDB5D768D6AC59949E9E2E7D475BBEF9F65BE9481DA5F507D73752AC500DEC1F564EAC560356FD9FCEE82B9D317680E487DED82B2DA212402443AEEEAB6FA130FAC0F5ED9FDB5D3A6B8B91D97A870FB78C29B3328B2F923028C158A8EBAEBB8E3EFEF863FA60E947420C51EE110BCB10A20BF71616E9575F7D25446FDEBC79C7452B121B227472C8890FB8BD98346D0588B011F03CDE94C71E945D984D7EC8981A87A506CF098C8EFF9C922466E6A1EF5499D090C1B569D3A64967EA4018E48C23E256665BB6202A487C680151C51B568FAAAA2A5ABD7AB5B86DDBB64DC41661455989A1C993A6070F1E2C446970C89D3D3924B2789E8C72F0E04151C2A2E4861B6E38DEE1110E5C570C908590E36F21B7C1990116E9430F3D249D69030B10A28DE7ECA457BE96AE32D11069EE9F16510B20E071F9D6B821F3205D77DA3071AC2580E0821F5E247A79B580EB76DE79CDD387D1D1103E173012B0E0E6CF9F2F9DB5C58800AA51D7D040078A8BE9C081034214F1D8AAABABA9AEAEA51E2E2525451463E367E0F780FB88A9D2D1B6E8850B205EE6F820D1726B951F22E808B132F400EE38B2CD91900510FCF3EB4D74F3BA23E298B186DED6B748D822807B2BEBE9BC2F0CCE48638EB36662FBE3312B3D01BCE69A6B2206E4D1D70B2B0616D75B6FBD65CAF2C2BF7BEFBDF75A654B955815402510148CE737029239760B209E5FBDE404A6C0407CF16F94AB058C02AB7571E8794F498A1C0A500A205B81D1B3FAA7A799CEFECAD812B8E99591CCFDC12681F5A717B05782FDB791C01B1C584984C02ADAB1638774E64FB0C7580BD9F204BB76ED12F76639FDD4F186C42F1CBC061E3BD9B86BCFB4067DBF56C50FD8620102DE1D6C8EA79236520F85B0A13E2D3C6625B374E95231CA4A0F743BC8639BD0BBAA15EBD202252EE19D0B3210600C05B00A5C5EC426B57EBF70B0DF64D0A041D29935107FC42225994F3FFD5433AE871000E28D60C97BEFEB861BB4B8F6DA6B23667F6560519F74D249D25973D862EE565B6C91C0A1B7F3D708B60920F8C95725945F5A2F9D315AA0DFF7C7F5AD2D8DCD9B376BBA8846121BB0FC2EBEF862CB417C650C2C1C241FA211C09A9085B93124CA4689F6E7010820162BC9E8C5F520FE10252BCF1B80FB7BD5BC2B0CC70DE1E287D729BE7A2C9DD625E648678C1150F8FCC60523A5336BD8FAB1C385D1C638F5A8B9D14A465ADC10F3C3CE5C10BEB0DC08CA521A3F8225ED6A40BC207E4069319A61C4B0A1D29175A6251E908E18A3FCEE0CF385CFE1D82A80E7E7B6A7FE9949D219A3C6402AA7BCF6E6E2A546637AC8B402889FD9A40566E05929FCF502F870D0726B73BB37275BF03D91BA44B488D65D0710E1931B39916814587F66A6BE68617BE0E16779DCE2A3C7597BCCBB58465BDCE082C9713623899370E48E12BFA1977D969F2758CF563E00F077419DA21D9C9ED43C8895898C1DD61FB05D00D90AD4A6A9AE9672D3CD0F90C09BCCA815280F37402D9D59FCEA06EB09BBFCBC5A757F51CE92DACE9E0F7DBC36B2F8AD1311BBAC3F60BB0082DF0C34368F3F689C57B9959292ACBDC29119350282FFB002E152A1BCC30C9890EC47B47E2FD43FCAF13FABEEAFDC3E6707786D4CAEB5F63882845DD61F704400D194CCA3B2DA32AEBAB956CF0A4667FD2196258F7C4232C40C4113C09C9CE6AC2BCA50ACC63FED88FF29393983F787E861A7F5071C114070FB201E92A004A52FD1B84A462D40006B066FEABE7DCD4D1CC1A8783FA22580F2878A55D71FA1899E0607311805AF114E8668F3D0D9F6C45B651C1340A8347787B460B6F4251CD4C6194984C87CFDF5D7A2E5CA4C4B19AC203F6682B55A0C6501B41AFF43A6DDAEF89F124E86A883AE8F688A9ED5704C00C16F06B21508AC263F949849840094B5AC59B386060C18205D318696587819E5D46C2572EF34FA86AD60F6B9350ACAA43819D2963B26D83F83D2D64E10351ED9524E0B0BAAA4B360823597E774D35F22B5213F9FCA2294A17CF6D967115BE2C2C15E0C9478C8BB6E2381D1587DC2C6B923A31C4D6746434383983918E9F793414B99DC9A66152483F6EDDB278EFFF0873F88FB70B0F3041F2A56861F00CC4294F7A6287F5E24B2423F73E48811D2993AEB8B4AE89E428EA3CB4433F1450FC70510F30227AF3842550D8EFE1857A39CFAA285DE3418992F56AEA4BB7EF73BE9CC38C8061B15402C11C21E0D25C8947A751A8CDE141888175C7EB31F2A3298442D4F7541DB9DD1E758390D460B9E12D302A63D2F9F35CED2BCBF4838EA02034C6AF8ED20F3DBCAFC02263E1B9DFA12894856831646DF98C0A895E615220D6050F60B9B011F2A91442C1AF09AE13DC2CDDC7BF63047C40F382E8060666E5A608BA3E79DD8413A8A1E04EDE1D232C6D14B70C0FAB35AFA232F4F72925F8EE1BD21287B41738553C44400C1FD4383591C3D20CF5E2BE194534E918E9C01EE999FD05BF804F1B39AF4C1B63CA7C9ED6D7FCCCB6B3C3EA97962BA53C44C0051163337CF1E57D02B60E8698AC5CE0F2DE4997F4E11690DA7D7D073712180D575D6C6B7459BA431025E3B415E9C84C407862D3B49CC0410DC3420933A4531BDD56B5C7CA2F1E265A3E08D67B6C54D46CE58EAD12DCAE483DBD013C083474AA8B1CE5ADDE39061CEBBC0E02723D417ACFB1D243EAE19D54B3A738E98AA110299FF3B2C180991CCC426EA647042B019B0B7C3C8E29D7030F7EEF9E79F8F985D554EA9F603E888D10223B2AC147EA37EF0C413A31BD86A14BC86825813F8C2D4518E253E94C4DC1C439FF08C9EFA35717EE0CE8E876D777F65264F9E2C1D1967F080FE22B33875EA54E94A5B3056DF6F3140AB490E3D303DDBA9BF6D38F839F78E08D6CE10B8BE76F6FBEA11177FF4572157383DC979758F2767F675CE95C4FE59B375727221F3942953C4BD1ACA3D157EC1090134DB631D2D4EBE96DC46AC5C5F99B808206A03EF1FE45F2B10539FCD2CF1360BC626E959726AC8934F468F19A31943F4A30046AA03B482532D705AE0B5941790B6FA3F9E171BD757266E1909D4F6F87558C26D31A85EB864D66CE9C81872E33F5C2A7989BA12F41A1B4992780DBD61A8F820C03637B349A55EBD6267A1C8DC3FD6FC805BAF8161070891C592B80920F8FDD0F6BE74854FC9733E913078E000B1CED12869692D1637B6C785838D7046670E7A05D4F861D881163366CCA0993367D2DD77DF2D5D3146AC2D40108BD7543C81EBFBC019B17F5EE32A8070859F18D13C91D72F8C486FB0ADF52D1273E6CC918E22A34C6E8C1F3F5E243C94400CFC4624F777E2196788FBB163C7D2A44993C4B111C28745C402BCA6C6E4F877DF4EACB2BEE1C45500014C5E3F1548DFD82576936F2E0A5972469321E11D0FCA0101C86A22B1E237CA75862FC0EDED9397279D85FE6E37DE281DE983722227E3BB7ADC34CCFEB22A3710CBAC6F38711740800269BFF40AC7D255413CEFAAABAE92CEF4A9AEAE968E9A413618560F84E0B6DB6E13F5857EA3A15EBBCB032D85CADF79E4C89186420AF21ACD78E0473718BDBE4E8CB9328A2B0410A6EF33A38C0FFB742B764E7E31CAECD9B30D05F1EBEADA4E16B9FDF6DBE98D37DE1016A01FD11A840AD46A297FF2939F4847DA5859376A177E9C10F3C279F1AD3C707C1EA0193E282CA75B36797778EA95951B68BCC5380D1619192DD9C01E0AA5FBF6DE7BEFD1EBAFBF2E9DA973FEF9E7D3AC59B3A433A2AD5BB7EA76492809FF795630F3FB61206AB4DBD6761714D086F5EB85C087033776EE653F95CE5A7E1E1E1F5C61BDC409AC66B5F982F879FB0A8D2DBDC27C45AB25475F6DDB4D4F37C5A60BC569FE7EE1D898677DC3719500022F4F90BE7DFF479677446CDEBCD9F0C050C4FD94A51835B5B5F4D8FCF9BA73FF10E343C653C6CCCF43CC2B9A89D060C3860DAA56A81A76FC3C4C68DEBD7BB7EAB467B8BACA610618C03A445A6E8E76C1EDDBB78B633520806AC5E47BF7EE15435F8DA0FC7966C1DFFAEE1AEF8FC9726AC2B3595CE1022B413CD0AB2B35D7552689F1EFB106A2AB56DBA7C48FCB8E22A1D6D6873E5E3D718D34E6CACC5E1627C06BCCEBC43BEEA7C475028878E0B32777F0647DE0FBFDCEA5E71A7A534179EC170BA18E4F2F96E7444B98DB81D8E1A604D65FF83525915C53586FF100EEF9ABC7D26971923B84C32AA8F78B77DC4F89EB0410A03EF0AFA3BD591FB8FF8441F47CA7D3E8BF471B626E0DA2C059EBCD1D440B1028CB8450FB18C9B5467C4EAFB4085F8F25780DE1B5F4000DA67589CDED8C5EE6A5E9278BF7B75B70A50002D405DD37D49B229894994DEF741B470FD7C4D61A44305FAB4738A802088B0E597258C7A79E7AAA74559F3C9D844F4A4AEC0694E2B5038FC2EB569FCC535346D9BED7375A5C2B8000BB44BC5A240D11ACEAD85D64ECE0BA20781D0B30315A6D6F881FF7FD1A01161BE2A30811185D2C3F68D020E9A82D1D3AD8B7E3450BBC56F09AC16BA7C0277F36243D9CDCED6115570B20B86D907787264004933B7717AE0B3277B1728B67CF9963BAC19F6941CF4D6EE7F0BC44BC461EADEFEB0B775706430EDC92F408C7F50208E68FC8F26CA7882C8200AE4C2CDC6264852FBBECB256F140ABBB2F8208AC46D40A8683E7D36A995324F09A78BAB6A7788D94C5BE90C03190F18DC79003A3784200E54E11AFEE13518A205EDCB25BECA410A24EF0D24B2F3D2E821DDA07732B9F55D45ADEE4998A76226777FDE4EECAC819DF780C39308A671405DBA15E1DEBCDF218A014410017471642A31D126641B1EDBC79F3843B1C8B3DB67E42ADE5CDCE363839CEE797EC6E3810BFB72E3AC555195F355CD7091289F5476B68F66AED21976EA7A1A294EA0FB75DD69D5C5E4257671DA513DA4516F89E3D7B46DD9AF6DD77DFD1919212E94C9F13BA75A3134F3C513AB346AC7FDE8E1D3B68FF8103D2993E9D42965DF89ACB254B96D0934F3E299D3573C51557688E2013AD70FBF64967DAECAF6DA22F1A3AFA52F4947CF8E371AECBF8AAE13901042B0ED5D055EBFC278200CDEE97F6CE10252D5AC0A28B7624536161A1E1CC3062625DBB7695CEAC813631A3AD77283636BBF3249C83070F1AB6ACD131929BDB7A81FDF2E5CBDBF4FC2E5AB488CE3CF34CE9AC3558BFA9D78A8805ED0B771CA3778FF97FCFEF5B178F8DDB782BB37832A88606EA174EF6EEF49870775809DE20B337D6D182B50542A498F810FE0184582A06A79A050327F0B79CB9B692C5CF857833AB100222387FA87707A9EA8920C09B65EED644BA75D9B7B461E75EF2A0A1EE69C27B7ECF3DF75CC3A3CEF0B7C2DF0C7F3B7C980541F800A6BB7849FC80670510A0B0D2ABDD2220920802C48A6ED99D443FFA4F312DDEB833903DBDF120BCA530D2B0098090C28AAD7BE8FF7D592CFE667E8FF329419747BC475B59C1D30208D02DE2771104A27CE6501ACD585D46FFF7F5361173629C43B9200AF1C8A9175C209DB5A5AAAA8ADE5B954F17AC3C42F71426FBAE9C2512103F37767918C1F30208822282320B0AEA68DCDB9BE892C5AB68D3CE02AA8BC3082EBF0377575E1C75F3CD378BF5034AF09CE3B9BFE9CDCFE8A457BE16C21744BC2C7EC09359602DDE28ACA6BB36395353170BF4B2C391B8292F85A60DCDA3BCEE5DDBBC59D5E02C700B6A5960F0FEFBEF537171B1A8A50410BD23870ED16BF9BBC58750D0F1BAF8015F0920F0FA58FD684450C68818B200B6A0258000A2772024824B0A8ED1735B4A7CD5A6160D6E18676F07BE1340E0E73A41B35CDC279BE69DD881FA86C45099C564016C215C0011D3DB557C903EDE5ECC969E0A5E2B75D1C39702085804DB92177ACDFE6268279A90DB898E969685AC43632160BF0B20DE02487A7C5978845EDA5D4E6B4A82393BD1087E123FE05B0104689B9BB7B68CAA1ABCF92B3A21824A208823D3EA686CFB041A9C934E9D3B7756DD0FEC2701C4CBBDB4B494361E28A5D5E54DB4A13A2570595B2BA0B717D39CBDD0DE66065F0B20D85B591F12C152DA5BE5CDE08DD322A8242B89A87F5D099DDE2D9DFA67A650CFAC34218A280AF6A20042E870DB7DA48CB657D451415D12FDBB3C85E37826C1482B4C7571FB60032BF85E0041496D23FD22BF94569578339E134B115403FDC993FA9D40837232A95346AA10C4E476ED0C659B659C1440242AEA6B6B4591F8A1F22ADA525241CB76EE0F4C07869340FC5E9A3AC2D523ADA2211002086A1A9BE8BECDE5B4785FB574C55BC45B04D580C57876FB3A1AD2B31BF54C4DA02E9969941BBA47B205BB33E4A40BC412995458636AAB2A95D4353452FB8C74EAD6BDBB103580A404266997D63688DD2610B87D354DB479DF0176611D04939C1F3D2BBA05F56E27300228F3DCCE4A5AB0DD9825E236DC28828C3F71CBE272A7099C00022FD70AB208324EE3971A3F23045200C1D6B25AFAF986724F26475804192790A73863FA7A5008AC000224477EB7A99C961DF45E10894590B113C4FBB0BCC8AFC90E2D022D80325E8D0BB20832761094789F1A2C8012E81CB931DF7B45D32C828C55C4D6B6A9A37CD5D961161640055EAD17641164CC0297F78E09FD7D59DC6C06164015BC38568B4590318A1FC658D9050BA0065ECC1237D5D5526DD12EE98C615A83AE8EC7270D0B549637122C803AA07B64C1B60A5A58E09D9A411641468D20273AF4600134001224BFFEB69C8ED4364A57DC0D8B2023C3890E7D58000DE2356B90459081D577CDA85E81ABED33030BA0493063F0D66F2A3C111B64110C2688F53D74F610DFCDEE730216400BC01A5CB8BBCA13C5D32C82C182637DE660018C020C5B7D786BA5EB5BE95804FD0FD7F5598305D006902479786B056DAF70AF5BCC22E84FE0EEFEEE8CC19CE4B0080BA08DB8BD809A45D05F704173F4B000DA0CDAE95ED855E9DA6C318BA0F7E1ECAE7DB0003A04E283CFECAA72E5087E16416F8238DF2FC6F6E34E0E1B61017418B4D42DD851EDBA44098BA07760E1730E16C01881FAC11776D7B84A085904DD0D84EF9AD17DB89ECF415800638CDB2C421641F7C1C2173B5800E3849B62842C82EE805DDDD8C302186790357EBDB09A9EDF5519D769D42C82F101C30A7E3AB4075D363C978B98E3000BA04B407BDD3B4535B4A8A0326E05D52C82B10305CC578E3E9126F5C8E4729638C202E8429030597AA02E2EB5842C82CE821ABEF3079CC0F13D97C002E86264ABF01F8555945F5A2F5D751E16417B616BCFBDB0007A04648F1717D5D292E29A980C6665118C0E39B677F1E01E9CD470312C801E4476915F2BAC763471C222680E59F4D8C5F50E2C801EC769316411D44716BDB3FB75E3892C1E8405D047400CBF2C69A0778BAB6DCD24B308B60631BDB37273D8D2F3012C803E05F5859F1CACA5B5C7EAE8C3FD35515B87411641587967F5CAA173FBF7A0095D33B85ECF47B00006042451D69736462588411141A5E08DC849E324868F61010C2868C5CB2FA9A6FC0AA23547EB0C97D9F8510465977660B71CB6F002060B20731C5889DB4A6B8528165435D2BA90B5A85672E35511942DBBBCAC3421766CDD312C808C2E28C6DE1C12C57D157554509B1812C606DA565E4F85D58D54B46DB3F45DEE012297979D467DB3D38F0BDD80EC76949799C245C84C1B580099A840B2E5504D3D1DA869A2D29A3ADA7AA0445C2F286B9E72B3ABB4B99DAFA0B4F9FC70759DB83702C40C40D000440D40D800C42D3B3585BAA5265097D464765D19D3B000320C1358F823936198C0C202C8304C4021FAFF67966E2AF257BF970000000049454E44AE426082";
            int len = s.length();
            byte[] data = new byte[len / 2];
            for (int i = 0; i < len; i += 2) {
                data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                        + Character.digit(s.charAt(i+1), 16));
            }
            user.setFoto(data);
        }
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        return "login";
    }
}