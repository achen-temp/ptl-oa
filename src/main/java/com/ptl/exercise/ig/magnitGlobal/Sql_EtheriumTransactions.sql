##
SELECT address
FROM wallets
WHERE id IN (select wallet_id from transactions);
