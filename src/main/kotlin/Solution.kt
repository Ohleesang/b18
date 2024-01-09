import java.util.*


//I 숫자 : 큐에 주어진 숫자 삽입
//D 1 : 큐의 최댓값을 삭제
//D -1 : 큐에서 최솟값을 삭제


class Solution {
    fun solution(operations: Array<String>): IntArray {

        val que: Queue<Int> = LinkedList()


        operations.forEach {
            val list = it.split(" ")
            val input = list[0]
            val inputNum = list[1].toInt()

            when (input) {
                "I" -> que.add(inputNum)
                "D" ->
                    if (que.isNotEmpty()) {
                        if (inputNum == 1) {
                            //큐의 최댓값 삭제
                            que.remove(que.maxOrNull())
                        } else if (inputNum == -1) {
                            //큐의 최솟값 삭제
                            que.remove(que.min())
                        }
                    }
            }
        }

        var answer = intArrayOf()
        if (que.isEmpty()) answer = intArrayOf(0, 0)
        else {val max = que.maxOrNull()!!
            val min =que.minOrNull()!!
            answer = intArrayOf(max, min)
        }

        return answer
    }

}

fun main() {
    val a = Solution()
    a.solution(
        arrayOf(
            "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"
        )//0,0
    )
    a.solution(
        arrayOf(
            "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"
        )
    )//333,-45
}