package plx.repositories.git

import plx.utils.IHttpClient

interface IGitApi extends Serializable{

    IHttpClient http = null
    String host = null
    String accessToken = null

}