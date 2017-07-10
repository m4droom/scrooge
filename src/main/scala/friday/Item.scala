package friday

/**
  * Created by seed on 2017. 6. 16..
  */
case class Item(name: String, where: String) {
  require(name != null, "name is null")
  require(where != null, "where is null")
}
