import {test} from '@/api/test'
import {ref,
    onMounted,
    reactive
} from 'vue'
import {type Stars} from '@/types/test'
export default function (){
    let testList = reactive<Stars>([])
    onMounted(()=>{
        test().then((res) => {
            console.log(res, '111')
            testList.push(res[0])
            testList.push(res[1])
        }).catch((err) => {
            console.log(err, 'err')
        });
    })

    return {testList}
}
