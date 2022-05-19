# mysql 5.7 递归查询

## 查询 id=5 所有父级

```sql
SELECT
    ID.LEVEL, DATA.*
FROM
    (
        SELECT
            @id AS _id,
        ( SELECT @id := parent_id FROM table1 WHERE id = @id ) AS _pid,
        @l := @l + 1 AS LEVEL
        FROM
            table1,
            ( SELECT @id := 5, @l := 0 ) b
        WHERE
            @id > 0
    ) ID,
    table1 DATA
WHERE
    ID._id = DATA.id
ORDER BY
    LEVEL;
```

## 查询 id = 2 的所有子级

```sql
SELECT
    ID.LEVEL, DATA.*
FROM
    (
        SELECT
            @ids AS _ids,
        ( SELECT @ids := GROUP_CONCAT( id ) FROM table1 WHERE FIND_IN_SET( parent_id, @ids ) ) AS cids,
        @l := @l + 1 AS LEVEL
        FROM
            table1,
            ( SELECT @ids := 2, @l := 0 ) b
        WHERE
            @ids IS NOT NULL
    ) id,
    table1 DATA
WHERE
    FIND_IN_SET( DATA.id, ID._ids )
ORDER BY
    LEVEL, id
```