package plx.base.archetypes

interface ILanguage {
    String name = null
    String version = null
    ILanguageBuilder builder = null
    ILanguageRunner runner = null
}