<?php
    class Conexao
    {
        private static $instancia;

        private function __construct()
        {
            $hostname = "localhost";
            $database = "carrospessoa";
            $username = "root";
            $password = "";

            $dsn = "mysql:host=$hostname;dbname=$database";
            $options = [
                PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
                PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
                PDO::ATTR_EMULATE_PREPARES => false
            ];

            try {
                self::$instancia = new PDO($dsn, $username, $password, $options);
            } catch (Exception $e) {
                echo $e->getMessage();
                exit;
            }
        }

        public static function getConexao()
        {
            if (!isset(self::$instancia)) {
                new Conexao();
            }
            return self::$instancia;
        }

    }

    function insertPessoa($nome, $login, $senha) {
        try {
            $conexao = Conexao::getConexao();
            $conexao->beginTransaction();

            $stmt = $conexao->prepare("INSERT INTO pessoa(nome, login, senha) VALUES (?, ?, ?)");
            $stmt->execute([$nome, $login, $senha]);

            echo "Inserido com sucesso!" . "<br>Linhas afetadas: " . $stmt->rowCount() . "<br><br>";
            $conexao->commit();
        }
        catch (Exception $e) {
            echo $e->getMessage();
            $conexao->rollBack();
            exit;
        }
    }

    function insertCarro($nome, $marca, $ano, $idPessoa) {
        try {
            $conexao = Conexao::getConexao();
            $conexao->beginTransaction();

            $stmt = $conexao->prepare("INSERT INTO carros(nome, marca, ano, idPessoa) VALUES (?, ?, ?, ?)"); 
            $stmt->execute([$nome, $marca, $ano, $idPessoa]);
            
            echo "Inserido com sucesso!" . "<br>Linhas afetadas: " . $stmt->rowCount() . "<br><br>";
            $conexao->commit();
        }
        catch (Exception $e) {
            echo $e->getMessage();
            $conexao->rollBack();
            exit;
        }
    }
    
    function deleteCarro($nome, $idPessoa) {
        try {
            $conexao = Conexao::getConexao();
            $conexao->beginTransaction();

            $stmt = $conexao->prepare("DELETE FROM carros WHERE nome = :nomeCarro and idPessoa = :idPessoa");
            $stmt->execute([
                "nomeCarro" => $nome,
                "idPessoa" => $idPessoa
            ]);

            echo "Removido com sucesso!" . "<br>Linhas afetadas: " . $stmt->rowCount() . "<br><br>";
            $conexao->commit();
        }
        catch (Exception $e) {
            echo $e->getMessage();
            $conexao->rollBack();
            exit;
        }
    }

    function selectCarros() {
        try {
            $conexao = Conexao::getConexao();
            $conexao->beginTransaction();

            $stmt = $conexao->prepare("SELECT nome, marca, ano FROM carros");
            $stmt->execute();

            foreach($stmt as $carro) {
                echo "Nome: " . $carro["nome"] . "<br>";
                echo "Marca: " . $carro["marca"] . "<br>";
                echo "Ano: " . $carro["ano"] . "<br><br>";
            }

            $conexao->commit();
        }
        catch (Exception $e) {
            $e->getMessage();
            $conexao->rollBack();
            exit;
        }
    }

    function selectCarroById($id) {
        try {
            $conexao = Conexao::getConexao();
            $conexao->beginTransaction();

            $stmt = $conexao->prepare("SELECT nome, marca, ano FROM carros WHERE id = ?");
            $stmt->execute([$id]);

            foreach($stmt as $carro) {
                echo "Nome: " . $carro["nome"] . "<br>";
                echo "Marca: " . $carro["marca"] . "<br>";
                echo "Ano: " . $carro["ano"] . "<br><br>";
            }

            $conexao->commit();
        }
        catch (Exception $e) {
            $e->getMessage();
            $conexao->rollBack();
            exit;
        }
    }

    function selectCarrosFetchAll() {
        try {
            $conexao = Conexao::getConexao();
            $conexao->beginTransaction();

            $stmt = $conexao->prepare("SELECT * FROM carros");
            $stmt->execute();
            $resultado = $stmt->fetchAll();

            var_dump($resultado);
            
            $conexao->commit();
        }
        catch (Exception $e) {
            $e->getMessage();
            $conexao->rollBack();
            exit;
        }
    }

    function selectCarroLike($text) {
        try {
            $conexao = Conexao::getConexao();
            $conexao->beginTransaction();

            $stmt = $conexao->prepare("SELECT * FROM carros WHERE nome LIKE CONCAT('%', :param, '%')");
            $stmt->execute([
                "param" => $text
            ]);

            foreach($stmt as $carro) {
                echo "Nome: " . $carro["nome"] . "<br>";
                echo "Marca: " . $carro["marca"] . "<br>";
                echo "Ano: " . $carro["ano"] . "<br>";
                echo "idPessoa " . $carro["idPessoa"] . "<br><br>";
            }
        }
        catch (Exception $e) {
            $e->getMessage();
            $conexao->rollBack();
            exit;
        }
    }

    /*
    insertPessoa("Jorge", "jorge@login.com", "jorgesenha");
    insertCarro("Ford Fiesta", "Ford", 2017, 1);
    insertCarro("Ford KA", "Ford", 2014, 1);
    deleteCarro("Ford KA", 1);
    selectCarros();
    selectCarroById(1);
    selectCarrosFetchAll();
    selectCarroLike("Ford");
    */
?>
