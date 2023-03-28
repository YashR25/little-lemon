package com.example.littlelemon

@kotlinx.serialization.Serializable
data class MenuNetworkData(
    val menu: List<MenuItemNetwork>
)

@kotlinx.serialization.Serializable
data class MenuItemNetwork(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: String,
    val category: String
) {
    fun toMenuItemRoom(): MenuItemRoom{
        return MenuItemRoom(
            id,
            title,
            description,
            price,
            image,
            category
        )
    }
}
