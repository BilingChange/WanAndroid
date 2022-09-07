/**
 * @description:Maven仓库配置
 *
 * @author: bili
 * @e-mail: bilingchange@126.com
 * @date: on 2022/6/1    17:32.
 **/
object PublishConfig {

    /**
     * 阿里云仓库配置
     */
    val aliyunConfig = AliYunMavenConfig

    object AliYunMavenConfig{
        /**
         * group_id
         */
        const val group_id = "com.github.bili"
        /**
         * 仓库版本号
         */
        const val version = "1.0.0-SNAPSHOT"
        /**
         * 仓库制品id
         */
        const val artifact_id = "common"
        /**
         * 仓库用户名
         */
        const val username = "606da6f56d822d6b011e3319"
        /**
         * 仓库密码
         */
        const val password = "6jJEoBqSZ=c["
        /**
         * 仓库正式地址
         */
        const val url_releases = "https://packages.aliyun.com/maven/repository/2092675-release-3qguRa/"
        /**
         * 仓库测试地址
         */
        const val url_snapshots = "https://packages.aliyun.com/maven/repository/2092675-snapshot-517ENa/"
    }
}