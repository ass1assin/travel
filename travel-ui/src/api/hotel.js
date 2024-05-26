import request from '@/utils/request'

export function getHotel(data){
  return request({
    url:'/hotel',
    method: 'get'
  })
}
