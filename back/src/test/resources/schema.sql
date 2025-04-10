-- users 儲存使用者基本資訊
CREATE TABLE IF NOT EXISTS users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(256) NOT NULL UNIQUE,
  password VARCHAR(256) NOT NULL,
  created_date TIMESTAMP NOT NULL
);
-- stocks	股票基本資料
CREATE TABLE IF NOT EXISTS stocks (
  stock_id INT AUTO_INCREMENT PRIMARY KEY,
  symbol VARCHAR(20) NOT NULL UNIQUE, -- e.g. "2330.TW"
  name VARCHAR(100),
  market VARCHAR(20), -- e.g. "TWSE", "NASDAQ"
  industry VARCHAR(100),
  created_date TIMESTAMP NOT NULL
);
-- watchlist 使用者追蹤的股票清單
CREATE TABLE IF NOT EXISTS watchlist (
  watchlist_id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  stock_id INT NOT NULL,
  created_date TIMESTAMP NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (stock_id) REFERENCES stocks(stock_id)
);
-- stock_prices	股票每日歷史價格
CREATE TABLE IF NOT EXISTS stock_prices (
  stock_price_id INT AUTO_INCREMENT PRIMARY KEY,
  stock_id INT NOT NULL,
  trade_date DATE NOT NULL,
  open_price DECIMAL(10, 2),
  close_price DECIMAL(10, 2),
  high_price DECIMAL(10, 2),
  low_price DECIMAL(10, 2),
  volume BIGINT,
  FOREIGN KEY (stock_id) REFERENCES stocks(stock_id),
  UNIQUE (stock_id, trade_date)
);
-- news_articles	抓取的新聞文章
CREATE TABLE IF NOT EXISTS news_articles (
  news_article_id INT AUTO_INCREMENT PRIMARY KEY,
  stock_id INT, -- 可選：關聯標的股票
  title VARCHAR(255),
  content TEXT,
  source VARCHAR(100),
  url TEXT,
  published_at TIMESTAMP,
  created_date TIMESTAMP NOT NULL,
  FOREIGN KEY (stock_id) REFERENCES stocks(stock_id)
);
-- news_sentiments	DeepSeek 對新聞進行情緒分析與摘要後的資料
CREATE TABLE IF NOT EXISTS news_sentiments (
  news_sentiments_id INT AUTO_INCREMENT PRIMARY KEY,
  news_article_id INT NOT NULL,
  sentiment_score DECIMAL(5, 2),  -- 例：-1.00（極度利空）~ +1.00（極度利多）
  summary TEXT,
  keywords TEXT,
  created_date TIMESTAMP NOT NULL,
  FOREIGN KEY (news_article_id) REFERENCES news_articles(news_article_id)
);
-- price_predictions	根據新聞和股價產出的預測結果
CREATE TABLE IF NOT EXISTS price_predictions (
  price_predictions_id INT AUTO_INCREMENT PRIMARY KEY,
  stock_id INT NOT NULL,
  prediction_date TIMESTAMP NOT NULL,
  predicted_range_low DECIMAL(10, 2),
  predicted_range_high DECIMAL(10, 2),
  confidence DECIMAL(5, 2), -- 置信度（如 0.85）
  source_model VARCHAR(100), -- 例如 "DeepSeek-2025-v1"
  created_date TIMESTAMP NOT NULL,
  FOREIGN KEY (stock_id) REFERENCES stocks(stock_id),
  UNIQUE (stock_id, prediction_date)
);