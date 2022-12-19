package es.unex.trackstone10

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.unex.trackstone10.domain.*
import es.unex.trackstone10.roomdb.Entity.DeckEntity
import es.unex.trackstone10.roomdb.Entity.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackstoneViewModel @Inject constructor(
    private val registerUser: RegisterUseCase,
    private val loginUser: LoginUseCase,
    private val getAllCardsUseCase: GetAllCardsUseCase,
    private val getCardsByNameUseCase: GetCardsByNameUseCase,
    private val getAllHeroesUseCase: GetAllHeroesUseCase,
    private val getHeroesByNameUseCase: GetHeroesByNameUseCase,
    private val deleteUserUseCase : DeleteUserUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val getAllDeckUseCase : GetAllDecksUseCase,
    private val modifyUserUseCase: ModifyUserUseCase,
    private val addCardFavoriteUseCase: AddCardFavoriteUseCase,
    private val addCardbackFavoriteUseCase: AddCardbackFavoriteUseCase,
    private val deleteFavoriteCardUseCase: DeleteFavoriteCardUseCase,
    private val deleteFavoriteHeroesUseCase: DeleteFavoriteClassUseCase,
    private val deleteFavoriteCardbackUseCase: DeleteFavoriteCardbackUseCase,
    private val createDeckUseCase: CreateDeckUseCase,
    private val deleteDeckUseCase: DeleteDeckUseCase,
    private val getCardbacksFromApiUseCase: GetCardbacksFromApiUseCase,
    private val getCardbacksByNameFromApiUseCase: GetCarbacksByNameFromApiUseCase,
    private val addHeroFavoriteUseCase: AddFavoriteHeroUseCase,
    private val getCardsByClassFromApiUseCase: GetCardsByClassFromApiUseCase,
    private val getCardsByClassAndNameUseCase: GetCardsByClassAndNameUseCase,
    private val getDeckListUseCase: GetDeckListUseCase,
    private val getCardFromDeckListUseCase: GetCardFromDeckUseCase,
    private val deleteCardFromDeckUseCase: DeleteCardFromDeckUseCase,
    private val getDeckUseCase: GetDeckUseCase,
    private val getDeckListCountUseCase: GetDecklistCountUseCase,
    private val getAllCardsFromDatabaseUseCase: GetAllCardsFromDatabaseUseCase,
    private val getCardsByNameFromDatabaseUseCase: GetCardsByNameDatabaseUseCase,
    private val getAllCardbacksFromDatabaseUseCase: GetAllCardbacksFromDatabaseUseCase,
    private val getCardbacksByNameFromDatabaseUseCase: GetCardbackByNameFromDatabaseUseCase,
    private val getAllHerosFromDatabaseUseCase: GetAllHerosFromDatabaseUseCase,
    private val getHerosByNameFromDatabaseUseCase: GetHerosByNameFromDatabaseUseCase
) : ViewModel() {

    val registerResult = MutableLiveData<Boolean>()
    val loginResult = MutableLiveData<Boolean>()
    val deleteResult = MutableLiveData<Boolean>()
    val modifyUserResult = MutableLiveData<Boolean>()
    val allCards = MutableLiveData<List<CardModel>>()
    val searchedCards = MutableLiveData<List<CardModel>>()
    val allHeroes = MutableLiveData<List<CardModel>>()
    val searchedHeroes = MutableLiveData<List<CardModel>>()
    val addCardFavoriteResult = MutableLiveData<Boolean>()
    val addCardbackFavoriteResult = MutableLiveData<Boolean>()
    val deleteFavoriteCardResult = MutableLiveData<Boolean>()
    val deleteFavoriteHeroesResult = MutableLiveData<Boolean>()
    val deleteFavoriteCardbackResult = MutableLiveData<Boolean>()
    val displayUserValues = MutableLiveData<UserEntity>()
    val allDecks = MutableLiveData<List<DeckEntity>>()
    val deckById = MutableLiveData<DeckEntity>()
    val createDeckResult = MutableLiveData<Int>()
    val deleteDeckResult = MutableLiveData<Boolean>()
    val allCardbacks = MutableLiveData<List<CardBackModel>>()
    val searchedCarbacks = MutableLiveData<List<CardBackModel>>()
    val addHeroFavoriteResult = MutableLiveData<Boolean>()
    val cardsByClass = MutableLiveData<List<CardModel>>()
    val cardsByClassAndName = MutableLiveData<List<CardModel>>()
    val deckList = MutableLiveData<List<CardModel>>()
    val cardsFromDeckByName = MutableLiveData<List<CardModel>>()
    val deleteCardFromDeckResult = MutableLiveData<Int>()
    val deckCount = MutableLiveData<Int>()
    val getAllCardsFromDatabaseResult = MutableLiveData<List<CardModel>>()
    val getCardsByNameResult = MutableLiveData<List<CardModel>>()
    val getAllCardBacksFromDatabaseResult = MutableLiveData<List<CardBackModel>>()
    val getCardBacksByNameFromDatabaseResult = MutableLiveData<List<CardBackModel>>()
    val getHerosByNameFromDatabaseResult = MutableLiveData<List<CardModel>>()
    val getAllHerosFromDatabaseResult = MutableLiveData<List<CardModel>>()

    fun register(user: UserEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = registerUser(user)
            registerResult.postValue(result)
        }
    }

    fun login(query1: String, query2: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = loginUser(query1, query2)
            loginResult.postValue(result)
        }
    }

    fun deleteUser(userId: Int?){
        viewModelScope.launch(Dispatchers.IO){
            val result = deleteUserUseCase(userId)
            deleteResult.postValue(result)
        }
    }



    fun modifyUser(query: String, userId: Int, param: Int){
        viewModelScope.launch(Dispatchers.IO){
            val user = getUserUseCase(userId)
            var result = false
            if(user != null){
                when (param){
                    1 -> user.mail = query
                    2 -> user.username = query
                    3 -> user.password = query
                }
                result = modifyUserUseCase(user)
            }
            modifyUserResult.postValue(result)
        }
    }

    fun addCard(card : CardModel, userId: Int){
        CoroutineScope(Dispatchers.IO).launch{
            val result = addCardFavoriteUseCase(card, userId)
            addCardFavoriteResult.postValue(result)
        }
    }

    fun addCardback(cardback : CardBackModel){
        CoroutineScope(Dispatchers.IO).launch{
            val result = addCardbackFavoriteUseCase(cardback)
            addCardbackFavoriteResult.postValue(result)
        }
    }

    fun deleteCard(name : String?){
        viewModelScope.launch(Dispatchers.IO){
            val result = deleteFavoriteCardUseCase(name)
            deleteFavoriteCardResult.postValue(result)
        }
    }

    fun deleteHero(id : Int?){
        viewModelScope.launch(Dispatchers.IO){
            val result = deleteFavoriteHeroesUseCase(id)
            deleteFavoriteHeroesResult.postValue(result)
        }
    }

    fun deleteCardback(id : Int?){
        viewModelScope.launch(Dispatchers.IO){
            val result = deleteFavoriteCardbackUseCase(id)
            deleteFavoriteCardbackResult.postValue(result)
        }
    }

    fun getAllCards() {
        viewModelScope.launch {
            val result = getAllCardsUseCase()
            allCards.postValue(result)
        }
    }

    fun getAllCardsDatabase(userId : Int?){
        CoroutineScope(Dispatchers.IO).launch {
            val result = getAllCardsFromDatabaseUseCase(userId)
            getAllCardsFromDatabaseResult.postValue(result)
        }
    }

    fun getCardsByNameDatabase(query: String,userId : Int?){
        CoroutineScope(Dispatchers.IO).launch {
            val result = getCardsByNameFromDatabaseUseCase(query, userId)
            getCardsByNameResult.postValue(result)
        }
    }

    fun getAllCardBacksDatabase(userId: Int?){
        CoroutineScope(Dispatchers.IO).launch{
            val result = getAllCardbacksFromDatabaseUseCase(userId)
            getAllCardBacksFromDatabaseResult.postValue(result)
        }
    }

    fun getCardBacksByNameDatabase(query: String, userId : Int?){
        CoroutineScope(Dispatchers.IO).launch {
            val result = getCardbacksByNameFromDatabaseUseCase(query,userId)
            getCardBacksByNameFromDatabaseResult.postValue(result)
        }
    }

    fun getAllHerosDatabase(userId: Int?){
        CoroutineScope(Dispatchers.IO).launch {
            val result = getAllHerosFromDatabaseUseCase(userId)
            getAllHerosFromDatabaseResult.postValue(result)
        }
    }

    fun getHerosByNameDatabase(query: String,userId: Int?){
        CoroutineScope(Dispatchers.IO).launch {
            val result = getHerosByNameFromDatabaseUseCase(query,userId)
            getHerosByNameFromDatabaseResult.postValue(result)
        }
    }


    fun getCardsByName(query: String) {
        viewModelScope.launch {
            val result = getCardsByNameUseCase(query)
            searchedCards.postValue(result)
        }
    }

    fun getAllHeroes(){
        viewModelScope.launch {
            val result = getAllHeroesUseCase()
            allHeroes.postValue(result)
        }
    }

    fun getHeroesByName(query: String){
        viewModelScope.launch{
            val result = getHeroesByNameUseCase(query)
            searchedHeroes.postValue(result)
        }
    }

    fun getUserToDisplay(userId: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val result = getUserUseCase(userId)
            displayUserValues.postValue(result)
        }
    }

    fun getAllCardbacks() {
        viewModelScope.launch {
            val result = getCardbacksFromApiUseCase()
            allCardbacks.postValue(result)
        }
    }

    fun getCarbacksByName(query: String) {
        viewModelScope.launch {
            val result = getCardbacksByNameFromApiUseCase(query)
            searchedCarbacks.setValue(result)
        }
    }

    fun addHero(hero: CardModel, userId: Int) {
        CoroutineScope(Dispatchers.IO).launch{
            val result = addHeroFavoriteUseCase(hero, userId)
            addHeroFavoriteResult.postValue(result)
        }
    }

    fun addDeck(deck : DeckEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = createDeckUseCase(deck)
            createDeckResult.postValue(result)
        }
    }

    fun deleteDeck(deck: DeckEntity){
        CoroutineScope(Dispatchers.IO).launch {
            val result = deleteDeckUseCase(deck.id)
            deleteDeckResult.postValue(result)
            if(result){
                val result2 = getAllDeckUseCase()
                allDecks.postValue(result2)
            }
        }
    }

    fun getAllDecks(){
        CoroutineScope(Dispatchers.IO).launch{
            val result = getAllDeckUseCase()
            allDecks.postValue(result)
        }
    }

    fun getCardsByClass(query: String){
        viewModelScope.launch {
            val result = getCardsByClassFromApiUseCase(query)
            cardsByClass.postValue(result)
        }
    }

    fun getCardsByClassAndName(query1: String, query2: String){
        viewModelScope.launch {
            val result = getCardsByClassAndNameUseCase(query1, query2)
            cardsByClassAndName.postValue(result)
        }
    }

    fun getDeck(deckId: Int){
        CoroutineScope(Dispatchers.IO).launch{
            val result = getDeckUseCase(deckId)
            deckById.postValue(result)
        }
    }

    fun getDecklistCount(deckId: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val result = getDeckListCountUseCase(deckId)
            deckCount.postValue(result)
        }
    }

    fun getDeckList(deckId: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val result = getDeckListUseCase(deckId)
            deckList.postValue(result)
        }
    }

    fun getCardFromDeckList(query: String, deckId: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val result = getCardFromDeckListUseCase(query, deckId)
            cardsFromDeckByName.postValue(result)
        }
    }

    fun deleteCardFromDeck(deckId: Int, name: String){
        CoroutineScope(Dispatchers.IO).launch {
            val result = deleteCardFromDeckUseCase( name, deckId)
            deleteCardFromDeckResult.postValue(result)
            if(result == 1) {
                val result2 = getDeckListUseCase(deckId)
                deckList.postValue(result2)
            }
        }
    }
}
