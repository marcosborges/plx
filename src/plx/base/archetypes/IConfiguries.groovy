package plx.base.archetypes

interface IConfiguries {
    List files = []
    Map getUnknown()
    Map getSecret()
    List getSecrets(secret)
    void setSecret(secret)
    boolean removeSecret(secret)
    boolean changeSecret(secret)
}