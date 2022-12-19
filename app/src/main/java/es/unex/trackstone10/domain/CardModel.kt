package es.unex.trackstone10.domain

import es.unex.trackstone10.API.CardResponse
import es.unex.trackstone10.roomdb.Entity.CardEntity
import es.unex.trackstone10.roomdb.Entity.ClassEntity
import es.unex.trackstone10.roomdb.Entity.DeckListCardEntity
import java.io.Serializable

data class CardModel(
    val id: Int?,
    val name: String?,
    val rarity: Int?,
    val cardclass: Int?,
    val manacost: Int?,
    val info: String?,
    val type: String?,
    val race: String?,
    val artist: String?,
    val flavorText: String?
) : Serializable

fun CardResponse.toCardModel(): CardModel {
    var type = ""
    when (cardTypeId){
        3 -> type = "Heroe"
        4 -> type = "Minion"
        5 -> type = "Spell"
        7 -> type = "Weapon"
        39 -> type = "Location"
    }
    var race = ""
    if(cardTypeId == 4 ||cardTypeId == 5) {
        when(cardTypeId){
            4 -> when(spellSchoolId){
                1 -> race = "Arcane"
                2 -> race = "Fire"
                3 -> race = "Frost"
                4 -> race = "Nature"
                5 -> race = "Holy"
                6 -> race = "Shadow"
                7 -> race = "Fel"
            }
            5 -> when(minionTypeId){
                1 -> race = "Blood elf"
                2 -> race = "Draenei"
                3 -> race = "Dwarf"
                4 -> race = "Human"
                6 -> race = "Night elf"
                7 -> race = "Orc"
                8 -> race = "Tauren"
                9 -> race = "Troll"
                10 -> race = "Undead"
                14 -> race = "Murloc"
                15 -> race = "Demon"
                17 -> race = "Mech"
                18 -> race = "Elemental"
                20 -> race = "Beast"
                21 -> race = "Totem"
                23 -> race = "Pirate"
                24 -> race = "Dragon"
                26 -> race = "All"
                43 -> race = "Quilboar"
                88 -> race = "Half-Orc"
                92 -> race = "Naga"
                93 -> race = "Old God"
                94 -> race = "Pandaren"
                95 -> race = "Gronn"
            }
        }
    }
    return CardModel(
        id,name, rarityId, classId, manaCost, image,
        type,race, artistName, flavorText)

}


fun CardEntity.toCardModel() =  CardModel(id,name, rarity, cardclass, manacost, info, type, race, "", "")

fun CardModel.toCardEntity(userid:Int) = CardEntity(name, rarity, cardclass, manacost, info, type, race, userid)

fun DeckListCardEntity.toCardModel() = CardModel(id, card_name, card_rarity, card_class, card_manacost, image, "", "", "", "")

fun CardModel.toDeckListEntity(userId: Int, deckId: Int) = DeckListCardEntity(deckId,userId, name, 1, rarity, cardclass, manacost, info)

fun ClassEntity.toCardModel() = CardModel(id, name,0,idhero,0,url,"hero","","","")

fun CardModel.toClassEntity(userId: Int) = ClassEntity(name, cardclass, info, userId)
