-- users
INSERT INTO users (user_id, email, password, created_date)
VALUES (1, 'testuser@example.com', 'hashedpassword123', NOW());

-- stocks
INSERT INTO stocks (stock_id, symbol, name, market, industry, created_date)
VALUES (1, '2330.TW', '台積電', 'TWSE', '半導體', NOW());

-- watchlist
INSERT INTO watchlist (watchlist_id, user_id, stock_id, created_date)
VALUES (1, 1, 1, NOW());

-- stock_prices
INSERT INTO stock_prices (
  stock_price_id, stock_id, trade_date, open_price, close_price, high_price, low_price, volume
)
VALUES (1, 1, CURDATE(), 600.00, 610.00, 615.00, 595.00, 12500000);

-- news_articles
INSERT INTO news_articles (
  news_article_id, stock_id, title, content, source, url, published_at, created_date
)
VALUES (
  1,
  1,
  '台積電宣布3奈米新進展',
  '台積電今日宣布其3奈米製程進展順利，預計下季量產...',
  '經濟日報',
  'https://udn.com/news/article/3nm-tsmc',
  NOW(),
  NOW()
);

-- news_sentiments
INSERT INTO news_sentiments (
  news_sentiments_id, news_article_id, sentiment_score, summary, keywords, created_date
)
VALUES (
  1,
  1,
  0.85,
  '台積電3奈米技術進展快速，有望帶動股價成長',
  '台積電,3奈米,量產',
  NOW()
);

-- price_predictions
INSERT INTO price_predictions (
  price_predictions_id, stock_id, prediction_date, predicted_range_low, predicted_range_high, confidence, source_model, created_date
)
VALUES (
  1,
  1,
  DATE_ADD(NOW(), INTERVAL 1 DAY),
  605.00,
  625.00,
  0.88,
  'DeepSeek-2025-v1',
  NOW()
);
