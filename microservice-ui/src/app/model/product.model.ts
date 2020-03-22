export class Product {
    constructor(
        public id?: number,
        public productCode?: string,
        public productTitle?: string,
        public imageUrl?: string,
        public discountOffer?: number,
        public price?: number,
        public currentPrice?: number
    ) {}
}