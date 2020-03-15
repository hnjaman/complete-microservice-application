module.exports = function () {
    return {
        products: [
            {   
                id: 1, 
                productCode: "TW1", 
                productTitle: "Titan Watch",
                imageUrl: "titan.png", 
                discountOffer: null
            },
            {   
                id: 2, 
                productCode: "FTW1", 
                productTitle: "FastTrack Watch",
                imageUrl: "fasttrack.png", 
                discountOffer: 20
            },
            {   
                id: 3, 
                productCode: "RW1", 
                productTitle: "Rolex Watch",
                imageUrl: "rolex.png", 
                discountOffer: null
            }
        ],
        orders: []
    }
}