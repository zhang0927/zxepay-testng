import com.zxepay.security.sdk.JmeterCrypto;
import model.paymentOrder;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DatabaseUtil;

import java.io.IOException;


public class Order {

            String time=System.currentTimeMillis()+"";
                @Test(testName = "支付下单接口")

                public void paymentOrder() throws IOException {

                String orderNo=time;
                String req="{\n" +
                        "\t\"backNoticeUrl\": \"http://www.baidu.com\",\n" +
                        "\t\"businessPayCode\": \"010003339\",\n" +
                        //"\t\"businessPayCode\": \"12000020000050165052\",\n" +//银联非税
                        "\t\"deviceType\": \"0\",\n" +
                        //"\t\"subTotalFlag\": \"1\",\n" +////////
                        "\t\"ext\": {\n" +
                        "\t\t\"nonTaxable\": {\n" +
                        "\t\t\t\"chgAgenCode\": \"053001\",\n" +
                        "\t\t\t\"chgAgenName\": \"\",\n" +
                        "\t\t\t\"nontaxAccount\": \"\",\n" +
                        "\t\t\t\"nontaxAmt\": \"\",\n" +
                        "\t\t\t\"regionCode\": \"110000\"\n" +
                        "\t\t},\n" +
/*
                "\t\"ext\": {\n" +
	           "\t\t\"subTotalInfos\": {\n" +
	           "\t\t\t\"subTotalInfo\": [{\n" +
	           "\t\t\t\t\"subTotalAcct\": \"00020327\",\n" +//此部分代码适用于银联PC支付通道，操作时请注释其他代码
	           "\t\t\t\t\"subTotalAmount\": \"5\"\n" +
	           "\t\t\t}, {\n" +
	           "\t\t\t\t\"subTotalAcct\": \"00022132\",\n" +
	           "\t\t\t\t\"subTotalAmount\": \"5\"\n" +
	           "\t\t\t}]\n" +
	           "\t\t}\n" +
	           "\t},\n" +
	           "\t\"merchantNo\": \"000008\",\n" +
	           "\t\"merchantOrderNo\": \"1110006\",\n" +
	           "\t\"orderAmount\": \"1\",\n" +
	           "\t\"orderType\": \"0\",\n" +
	           "\t\"payType\": \"31\",\n" +
	           "\t\"productDesc\": \"1111\",\n" +
	           "\t\"spbillCreateIp\": \"192.168.1.1\",\n" +
	           "\t\"subTotalFlag\": \"1\"\n" +
	           "}";*/

/*
                "\t\t\"alipayk12\": {\n" +
                "\t\"chargeBillTitle\": \"test\",\n" +
                "\t\"classIn\": \"1\",\n" +
                "\t\"schoolNo\": \"64010500000108\",\n" +
                "\t\"schoolPid\": \"2088231701229409\",\n" +
                "\t\"studentCode\": \"64000019000000499929\",\n" +
                "\t\"studentIdentify\": \"1234567\",\n" +
                "\t\"parents\":{ \n" +
                "\t\"parent\": [\n" +
                	"\t{"+
   				 "\t\"parentName\": \"家长\",\n" +
   				 "\t\"parentMobileNo\": \"13100000000\"\n" +
  				"\t}"+
                "\t]},\n" +
                "\t\"chargeItems\": {\n" +
                "\t\"chargeItem\": [\n" +
                	"\t{"+
   				 "\t\"itemName\": \"住宿费\",\n" +
   				 "\t\"itemPrice\": \"0.02\"\n" +
  				"\t}"+
                "\t]},\n" +
                "\t\"childName\": \"小张\",\n" +
                "\t\"itemName\": \"住宿费\",\n" +
                "\t\"itemPrice\": \"2\",\n" +
                "\t\"parentMobile\": \"15589369893\"\n" +
                "\t\t},\n" +
*/
                        "\t\t\"payMent\": {\n" +
                        "\t\t\t\"billAmt\": \"1690\",\n" +
                        "\t\t\t\"billInfo\": {\n" +
                        "\t\t\t\t\"balance\": \"1\",\n" +
                        "\t\t\t\t\"beginDate\": \"1998/10\",\n" +
                        "\t\t\t\t\"contractNo\": \"56.000\",\n" +
                        "\t\t\t\t\"customerName\": \"东堂子胡同61号311门\",\n" +
                        "\t\t\t\t\"endDate\": \"1998/10\",\n" +
                        "\t\t\t\t\"filed1\": \"199810\",\n" +
                        "\t\t\t\t\"filed2\": \"1234567891234567891234567891234567891234\",\n" +
                        "\t\t\t\t\"filed3\": \"123456789123456789123456789123123456789\",\n" +
                        "\t\t\t\t\"filed4\": \"12345678912345678912345678912345123456789\",\n" +
                        "\t\t\t\t\"filed5\": \"\",\n" +
                        "\t\t\t\t\"payAmount\": \"30\"\n" +
                        "\t\t\t},\n" +
                        "\t\t\t\"customerName\": \"东堂子胡同61号3门\",\n" +
                        "\t\t\t\"filed1\": \"199810\",\n" +
                        "\t\t\t\"paymentItemCode\": \"827513568\",\n" +
                        "\t\t\t\"paymentItemId\": \"153505\",\n" +
                        "\t\t\t\"queryAcqSsn\": \"n20200330094904-8211Sb\",\n" +
                        "\t\t\t\"sessionId\": \"fc8aebb9f5afbf80d08cf72d10587615b7dc85d9890e79b6378107a4cb4a95e0164027aa9ae5200fe58b1a00f1d39eccb607e25d7eb5e091704e34c6c25eaa8d\"\n" +
                        "\t\t}\n" +
                        "\t},\n" +
                        "\t\"merchantNo\": \"000002\",\n" +
                        //"\t\"merchantOrderNo\": \"1596009740255\",\n" +
                        "\t\"merchantOrderNo\":"+orderNo+",\n" +
                        // "\t\"merchantOrderNo\": \"${orderNo}\",\n" +
                        "\t\"orderAmount\": \"1\",\n" +
                        "\t\"orderType\": \"18\",\n" +
                        "\t\"pageNoticeUrl\": \"http://www.baidu.com\",\n" +
                        "\t\"payType\": \"31\",\n" +
                        "\t\"productDesc\": \"测试商品111\",\n" +
                        "\t\"productName\": \"测试商品111\",\n" +
                        "\t\"spbillCreateIp\": \"127.0.0.1\",\n" +
                        "\t\"productId\": \"0001\",\n" +
                        "\t\"authCode\": \"134667379635619638\",\n" +
                        "\t\"wechatSceneInfo\": \"0001\",\n" +
                        //"\t\"openId\": \"oVysg5blqnhkPMSIhzVhRLLLnaCE\",\n" +微信非税H5
                        "\t\"openId\": \"oywBR0_MrUaZZ_-kf0r-_jfEAB8I\",\n" +//微信非税公众号/APP/E账单
                        //"\t\"wechatAppId\": \"wx027a14c8853bbf72\",\n" +//微信非税公众号/APP/E账单
                        //"\t\"openId\": \"oVysg5blqnhkPMSIhzVhRLLLnaCE\",\n" +//微信非税小程序
                        "\t\"wechatAppId\": \"wxda884ce8ae1cdeaf\",\n" +//微信非税小程序
                        //"\t\"authCode\": \"0001\",\n" +
                        //"\t\"agreementNo\": \"20205326605456580558\",\n" +
                        "\t\"timeExpire\": 0\n" +
                        "}";
                        System.out.println("请求参数为："+req);
                //加密请求
                String reqStr=JmeterCrypto.signAndEncrypt(req);
                System.out.println("加密后的请求参数"+reqStr);

                String url="http://192.168.1.131:8443/order-service/order/trade/order";

                //这是孙磊写的另一种方法，直接发送请求，不需要加header,一句话就能完成执行
                //String result =  HttpUtil.post(url,reqStr);

                //这是我自己的执行代码
                HttpPost post=new HttpPost(url);
                DefaultHttpClient client=new DefaultHttpClient();
                StringEntity  entity = new StringEntity(reqStr,"utf-8");
                post.setHeader("content-type","application/json");
                post.setEntity(entity);
                HttpResponse response=client.execute(post);

                String result;
                result= EntityUtils.toString(response.getEntity(),"utf-8");
                String resStr = JmeterCrypto.checkSignAndDecrypt(result);
                System.out.println("返回结果是："+resStr);

                JSONObject resultJson=JSON.parseObject(resStr);
                //获取到结果值

                String msg=resultJson.getString("msg");
                String code1=resultJson.getString("code");
                Assert.assertEquals(msg,"交易成功");
                Assert.assertEquals(code1,"0");

                JSONObject decryptContent=resultJson.getJSONObject("decryptContent");
                String code2=decryptContent.getString("code");
                Assert.assertEquals(code2,"000000");

                //数据库验证
                    SqlSession session= DatabaseUtil.getSqlSeeion();
                    paymentOrder paymentOrder;
                    paymentOrder = session.selectOne("orderPayment",time);
                    System.out.println(paymentOrder.toString());

                    //验证结果
                    org.testng.Assert.assertEquals(paymentOrder.getOrderstatus(),"1");

                }

                @Test(testName = "下单查询接口",dependsOnMethods = "paymentOrder")
                public void orderQuery() throws IOException {

                String req="{"+"\"merchantNo\":\"000002\""+"\"merchantOrderNo\":\"1595991202494\""+"}";
                String reqStr=JmeterCrypto.signAndEncrypt(req);

                String testUrl="http://192.168.1.131:8443/order-service/order/trade/orderquery";

                HttpPost post=new HttpPost(testUrl);
                StringEntity entity=new StringEntity(reqStr,"utf-8");
                post.setHeader("content-type","application/json");
                post.setEntity(entity);
                DefaultHttpClient client=new DefaultHttpClient();
                HttpResponse response=client.execute(post);
                String result=EntityUtils.toString(response.getEntity(),"utf-8");
                String resStr=JmeterCrypto.checkSignAndDecrypt(result);

                //打印返回结果
                        System.out.println("订单查询返回结果："+resStr);

                JSONObject json=JSON.parseObject(resStr);
                String code=json.getString("code");
                String msg=json.getString("msg");

                Assert.assertEquals(code,"0");
                Assert.assertEquals(msg,"交易成功");

                }

                @Test(testName = "退款支付",dependsOnMethods = "orderQuery")
                public void refundPayment() throws IOException {

                        String req="{"+"\"merchantNo\":\"000002\","+
                        "\"oriMerchantOrderNo\":\"1596003496369\","+
                        "\"merchantRefundOrderNo\":\"1111\","+
                        "\"refundOrderAmount\":\"1\","+
                        "\"refundNotifyUrl\":\"退款通知URL\","+
                        "\"remark\":\"test111\""+"}";

                        String reqStr=JmeterCrypto.signAndEncrypt(req);

                        String testUrl="http://192.168.1.131:8443/order-service/order/trade/refund";
                        HttpPost post=new HttpPost(testUrl);
                        post.setHeader("content-type","application/json");
                        StringEntity entity=new StringEntity(reqStr,"utf-8");
                        post.setEntity(entity);

                        DefaultHttpClient client=new DefaultHttpClient();
                        HttpResponse response=client.execute(post);

                        String result=EntityUtils.toString(response.getEntity(),"utf-8");

                        //返回结果解密
                        String resStr=JmeterCrypto.checkSignAndDecrypt(result);
                        System.out.println("返回结果是："+resStr);

                        //获取返回值中的code和msg
                        JSONObject json=JSON.parseObject(resStr);
                        String code=json.getString("code");
                        String msg=json.getString("msg");

                        //验证返回结果
                        Assert.assertEquals(code,"0");
                        Assert.assertEquals(msg,"交易成功");


                }
                @Test(testName = "退款查询",dependsOnMethods = "refundPayment")
                public void refundQuery() throws IOException {
                    String req="{"+"\"merchantNo\":\"000002\","+"\"merchantRefundOrderNo\":\"48246044159\""+"}";
                    //加密请求字符串
                    String reqStr=JmeterCrypto.signAndEncrypt(req);

                    String testUrl="http://192.168.1.131:8443/order-service/order/trade/refundquery";

                    HttpPost post=new HttpPost(testUrl);
                    //设置header
                    post.setHeader("content-type","application/json");
                    StringEntity entity=new StringEntity(reqStr,"utf-8");
                    post.setEntity(entity);

                    DefaultHttpClient client=new DefaultHttpClient();
                    HttpResponse response=client.execute(post);
                    HttpEntity result=response.getEntity();
                    String result1=EntityUtils.toString(result);

                    //解密返回结果
                    String resStr=JmeterCrypto.checkSignAndDecrypt(result1);
                    //打印返回结果
                    System.out.println("返回结果是："+resStr);

                    JSONObject resultJson=JSON.parseObject(resStr);
                    String code=resultJson.getString("code");
                    String msg=resultJson.getString("msg");

                    //JSONObject decryptContent= JSON.parseObject(resultJson.getString("decryptContent"));
                    JSONObject decryptContent=resultJson.getJSONObject("decryptContent");
                    String code1=decryptContent.getString("code");
                    String mesg=decryptContent.getString("mesg");

                    Assert.assertEquals(code,"0");
                    Assert.assertEquals(msg,"交易成功");
                    Assert.assertEquals(code1,"000000");
                    Assert.assertEquals(mesg,"处理成功");








                }
                @Test(testName = "资金划转",priority = 1)
                public void settleTransfer() throws IOException {
                    String req="{" +
                            "\"merchantNo\": \"000002\"," +
                            "\"noticeAddress\": \"190.16.12.12\"," +
                            "\"settleType\":\"12\"," +
                            "\"records\": [" +
                            "{\"acctType\":\"0\"," +
                            "\"cardByName\":\"北京博思致新互联网科技有限责任公司\"," +
                            "\"cardByNo\":\"321200100100260987\"," +
                            "\"amount\":\"1\"," +
                            "\"orderId\":\"202003111122\"," +
                            "\"bankCode\":\"CCB\"," +
                            "\"bankCity\":\"北京\"," +
                            "\"bankMobile\":\"11111111111\"," +
                            "\"bankOpenName\":\"兴业银行\"," +
                            "\"bankProvince\":\"北京\"," +
                            "\"idNumber\":\"1111111111\"," +
                            "\"idType\":\"00\"," +
                            "\"tradeTime\":\"1111\"," +
                            "\"unionpayNo\":\"111111\"," +
                            "\"remark\":\"test111\"" +
                            "}" +
                            // "},\n" +
                            //"{\"cardByName\":\"小2\"," +
                            //  "\"cardByNo\":\"6217000010021851566\"," +
                            //  "\"amount\":\"2\"," +
                            //  "\"orderId\":\"20191219171609\"," +
                            //  "\"bankCode\":\"CIB\"," +
                            //  "\"remark\":\"test\"" +
                            //  "}" +
                            "]" +
                            "}";
                    //请求加密
                    String reqStr=JmeterCrypto.signAndEncrypt(req);

                    String testUrl="http://223.223.190.130:8443/settle-service/settle/transfer";
                    HttpPost post=new HttpPost(testUrl);
                    post.setHeader("content-type","application/json");

                    StringEntity entity=new StringEntity(reqStr);
                    post.setEntity(entity);

                    DefaultHttpClient client=new DefaultHttpClient();
                    HttpResponse response=client.execute(post);
                    String result=EntityUtils.toString(response.getEntity(),"utf-8");
                    //返回结果解密
                    String resStr=JmeterCrypto.checkSignAndDecrypt(result);
                    //打印返回结果
                    System.out.println("返回结果是："+resStr);

                    JSONObject resultJson=JSON.parseObject(resStr);
                    String code=resultJson.getString("code");
                    String msg=resultJson.getString("msg");

                    Assert.assertEquals(code,"0");
                    Assert.assertEquals(msg,"交易成功");




                }
                @Test(testName = "资金划转查询",dependsOnMethods = "settleTransfer")
                public void settleQuery() throws IOException {

                    String testUrl="http://223.223.190.130:8443/settle-service/settle/query";
                    String req="{" +
                            "\"merchantNo\": \"000002\"," +
                            "\"serialNo\": \"20191219171608\"" +
                            //"\"tradeDate\": \"20191219\"" +
                            "}";
                    String reqStr = JmeterCrypto.signAndEncrypt(req);

                    HttpPost post=new HttpPost(testUrl);
                    post.setHeader("content-type","application/json");
                    StringEntity entity=new StringEntity(reqStr);
                    post.setEntity(entity);
                    DefaultHttpClient client=new DefaultHttpClient();
                    HttpResponse response=client.execute(post);
                    String result=EntityUtils.toString(response.getEntity(),"utf-8");

                    //返回结果解密
                    String resStr=JmeterCrypto.checkSignAndDecrypt(result);
                    System.out.println("返回结果是："+resStr);

                    //取返回结果的值
                    JSONObject resultObject=JSON.parseObject(result);
                    String code=resultObject.getString("code");
                    String msg=resultObject.getString("msg");
                    //验证返回结果
                    Assert.assertEquals(code,"000000");
                    Assert.assertEquals(msg,"交易成功");


                }

        }

