# LLNode-Project
A Project where I familiarized myself with LLNodes and class heirarchies. 
Trader - an entity that is allowed to trade stock
MarketMaker - a specific trader that is needed in order for there to be a market for the given stock 
BuyLimitOrder - a request to purchase stock
SellLimitOrder - a request to sell stock 
MarketBuyOrder - a request to purchase stock made specifically by a Market Maker 
MarketSellOrder - a request to sell stock made specifically by a Market Maker 
Transaction - represents the successful trade of a stock 
Market - uses LLNodes to keep track of the buying and selling of market sell orders and market buy orders for a specific stock. An LLNode class was created specifically
for the purposes of this project. 
