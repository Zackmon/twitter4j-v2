package twitter4j_v2_support_example

import twitter4j.JSONObject
import twitter4j.TwitterFactory
import twitter4j.TwitterObjectFactory
import twitter4j.conf.ConfigurationBuilder
import twitter4j.getUserTweets


fun main(@Suppress("UNUSED_PARAMETER") args: Array<String>) {

    //--------------------------------------------------
    // prepare twitter instance
    //--------------------------------------------------
    val conf = ConfigurationBuilder()
        .setJSONStoreEnabled(true)
        .build()

    val twitter = TwitterFactory(conf).instance
//    val twitter = TwitterFactory.getSingleton()

    //--------------------------------------------------
    // getUserTweets example
    //--------------------------------------------------
    val userId = 8379212L       // @takke
//    val userId = 2244994945L    // @TwitterDev
//    val userId = 87532773L      // @TwitterDesign
    println("simple")
    println("======")
    twitter.getUserTweets(userId, maxResults = 5).let {
        println(it)

        val json = JSONObject(TwitterObjectFactory.getRawJSON(it))
        println(json.toString(3))
    }

}
