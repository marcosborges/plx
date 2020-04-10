package plx.base.archetypes

interface IArchetype {
    String name = null
    ArchetypeTypes type = ArchetypeTypes.SERVICE
    ILanguage language = null
    IConfiguries configures = null
}