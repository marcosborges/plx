package plx.repositories.git

import plx.utils.IHttpClient

interface IGit extends Serializable{

    IHttpClient http = null
    String host = null
    String accessToken = null

}