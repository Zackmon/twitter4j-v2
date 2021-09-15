package twitter4j

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GetUserMentionsTest {

    @Test
    fun simpleById() {

        val twitter = V2TestUtil.createTwitterInstance()
        val userId = twitter.verifyCredentials().id     // me
        println("account id[$userId]")
        val res = twitter.getUserMentions(userId, maxResults = 5)
        println(res)

        val json = JSONObject(TwitterObjectFactory.getRawJSON(res))
        println(json.toString(3))

        // meta
        assertThat(res.meta?.resultCount).isEqualTo(5)
        assertThat(res.meta?.previousToken).isNull()
        assertThat(res.meta?.nextToken).isNotNull
        assertThat(res.meta?.oldestId).isNotNull
        assertThat(res.meta?.newestId).isNotNull

        assertThat(res.tweets.size).isEqualTo(5)
        res.tweets[0].let {
            assertThat(it.text.length).isGreaterThan(0)
        }
    }

}